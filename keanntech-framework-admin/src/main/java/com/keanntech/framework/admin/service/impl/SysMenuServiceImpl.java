package com.keanntech.framework.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.admin.mapper.AdminRoleMenuMapper;
import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.admin.service.SysMenuService;
import com.keanntech.framework.admin.util.AdminUtil;
import com.keanntech.framework.common.exception.ApiException;
import com.keanntech.framework.common.mapper.SysMenuMapper;
import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.model.SysMenu;
import com.keanntech.framework.common.model.SysMenuExample;
import com.keanntech.framework.common.model.SysMenuKey;
import com.keanntech.framework.common.util.UidGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Autowired
    SysAdminService sysAdminService;

    /**
     * 获取所有菜单的实体列表<br/>
     * 不关联role表
     * @return
     */
    @Override
    public List<SysMenu> getAllSysMenu() {
        SysMenuExample sysMenuExample = new SysMenuExample();
        return sysMenuMapper.selectByExample(sysMenuExample);
    }

    /**
     * 根据adminId获取菜单的实体列表<br/>
     * 此方法会关联role表，只有分配了权限的菜单才显示
     * @param adminId
     * @return
     */
    @Override
    public List<SysMenu> getAllSysMenu(Long adminId) {
        return adminRoleMenuMapper.getSysMenuList(adminId);
    }

    /**
     * 根据parentId获取实体菜单列表<br/>
     * 不关联权限表
     * @param parentId
     * @return
     */
    @Override
    public List<SysMenu> getChildrenMenu(Long parentId) {
        SysMenuExample sysMenuExample = new SysMenuExample();
        sysMenuExample.createCriteria().andParentIdEqualTo(parentId).andDeletedEqualTo(0);
        return sysMenuMapper.selectByExample(sysMenuExample);
    }

    /**
     * 保存菜单
     * @param sysMenu
     * @return
     */
    @Override
    public boolean saveMenu(SysMenu sysMenu) throws ParseException {
        SysAdmin sysAdmin = AdminUtil.getCurrentAdmin();
        if(this.menuTitleIsExist(sysMenu,false)) {
            throw new ApiException("菜单名称已存在");
        }
        if(this.menuUrlIsExist(sysMenu, false)) {
            throw new ApiException("路由已存在");
        }

        sysMenu.setId(UidGeneratorUtil.getUid());
        sysMenu.setCreateId(sysAdmin.getId());
        sysMenu.setUpdateId(sysAdmin.getId());
        sysMenu.setCreateTime(threadLocal.get().parse(DateUtil.now()));
        sysMenu.setUpdateTime(threadLocal.get().parse(DateUtil.now()));
        sysMenu.setDeleted(0);
        return sysMenuMapper.insert(sysMenu) >= 0 ? true : false;
    }

    /**
     * 更新菜单
     * @param sysMenu
     * @return
     * @throws ParseException
     */
    @Override
    public int updateMenu(SysMenu sysMenu) throws ParseException {
        if(this.menuTitleIsExist(sysMenu,true)) {
            throw new ApiException("菜单名称已存在");
        }
        if(this.menuUrlIsExist(sysMenu, true)) {
            throw new ApiException("路由已存在");
        }
        SysAdmin sysAdmin = AdminUtil.getCurrentAdmin();
        sysMenu.setUpdateTime(threadLocal.get().parse(DateUtil.now()));
        sysMenu.setUpdateId(sysAdmin.getId());
        SysMenuExample sysMenuExample = new SysMenuExample();
        sysMenuExample.clear();
        sysMenuExample.createCriteria().andIdEqualTo(sysMenu.getId());
        return sysMenuMapper.updateByExample(sysMenu,sysMenuExample);
    }

    @Override
    public int delMenu(Long menuId) {
        SysMenuKey sysMenuKey = new SysMenuKey();
        sysMenuKey.setId(menuId);
        return sysMenuMapper.deleteByPrimaryKey(sysMenuKey);
    }

    /**
     * 根据adminId获取菜单列表，可用于前端菜单树显示<br/>
     * 会关联role表，查询出给用户分配的菜单
     * @param adminId
     * @return
     */
    @Override
    public List<SysMenuParams> getMenuTree(Long adminId) {
        List<SysMenu> sysMenuList = this.getAllSysMenu(adminId);

        if (sysMenuList == null || sysMenuList.size() < 1) {
            return Collections.emptyList();
        }

        return this.getChildren(0l, sysMenuList);

    }

    /**
     * 递归调用此方法将子菜单构建成菜单树
     * @param parentId
     * @param sysMenuList
     * @return
     */
    private List<SysMenuParams> getChildren(Long parentId, List<SysMenu> sysMenuList) {
        List<SysMenu> childMenus = sysMenuList.stream().filter(sysMenu -> sysMenu.getParentId().longValue() == parentId).collect(Collectors.toList());

        if(childMenus == null || childMenus.size() < 1) {
            return Collections.emptyList();
        }

        List<SysMenuParams> sysMenuParamsList = new ArrayList<>();
        for (int i = 0, len = childMenus.size(); i < len; i++) {
            SysMenu sysMenu = childMenus.get(i);
            SysMenuParams sysMenuParams = this.setMenuItem(sysMenu);
            List<SysMenuParams> children = this.getChildren(sysMenu.getId(), sysMenuList);
            sysMenuParams.setChildren(children);

            sysMenuParamsList.add(sysMenuParams);
        }

        return sysMenuParamsList;
    }

    /**
     * 按前台菜单显示要求设置菜单属性
     * @param sysMenu
     * @return
     */
    private SysMenuParams setMenuItem(SysMenu sysMenu) {
        SysMenuParams sysMenuParams = new SysMenuParams();
        sysMenuParams.setId(sysMenu.getId());
        sysMenuParams.setHidden(sysMenu.getHidden());
        sysMenuParams.setParentId(sysMenu.getParentId());
        sysMenuParams.setPath(sysMenu.getUrl());
        sysMenuParams.setName(sysMenu.getName());
        sysMenuParams.setType(sysMenu.getType());
        if(sysMenu.getParentId().longValue() == 0 || sysMenu.getType().intValue() == 0) {
            sysMenuParams.setRedirect("noRedirect");
        }
        SysMenuParams.Meta meta = new SysMenuParams().new Meta();
        meta.setTitle(sysMenu.getTitle());
        meta.setIcon(sysMenu.getIcon());
        meta.setNoCache(true);
        sysMenuParams.setMeta(meta);
        return sysMenuParams;
    }

    /**
     * 查询菜单名称是否存在<br/>
     * 如果isUpdate为true，则排除自已本身查询是否有重复名称
     * @param sysMenu
     * @param isUpdate
     * @return
     */
    private boolean menuTitleIsExist(SysMenu sysMenu, boolean isUpdate) {
        SysMenuExample sysMenuExample = new SysMenuExample();
        SysMenuExample.Criteria criteria = sysMenuExample.createCriteria().andTitleEqualTo(sysMenu.getTitle());
        if(isUpdate){
            criteria.andIdNotEqualTo(sysMenu.getId());
        }
        List<SysMenu> sysMenuList = sysMenuMapper.selectByExample(sysMenuExample);
        return sysMenuList != null && sysMenuList.size() > 0 ? true : false;
    }

    /**
     * 查询路由(url)是否已存在，因为前台菜单路由不能重复<br/>
     * 如果isUpdate为true,则排除自己本身查询是否存在重复的路由
     * @param sysMenu
     * @param isUpdate
     * @return
     */
    private boolean menuUrlIsExist(SysMenu sysMenu, boolean isUpdate) {
        SysMenuExample sysMenuExample = new SysMenuExample();
        SysMenuExample.Criteria criteria = sysMenuExample.createCriteria().andUrlEqualTo(sysMenu.getUrl());
        if(isUpdate){
            criteria.andIdNotEqualTo(sysMenu.getId());
        }
        List<SysMenu> sysMenuList = sysMenuMapper.selectByExample(sysMenuExample);
        return sysMenuList != null && sysMenuList.size() > 0 ? true : false;
    }
}
