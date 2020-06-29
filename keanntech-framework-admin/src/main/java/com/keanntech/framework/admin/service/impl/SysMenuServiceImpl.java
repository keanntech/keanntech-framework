package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.admin.mapper.AdminRoleMenuMapper;
import com.keanntech.framework.admin.service.SysMenuService;
import com.keanntech.framework.common.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public List<SysMenu> getSysMenuList(Long adminId) {
        return adminRoleMenuMapper.getSysMenuList(adminId);
    }

    @Override
    public List<SysMenuParams> getMenuTree(Long adminId) {
        List<SysMenu> sysMenuList = this.getSysMenuList(adminId);

        if (sysMenuList == null || sysMenuList.size() < 1) {
            return Collections.emptyList();
        }

        return this.getChildren(0l, sysMenuList);

    }

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

    private SysMenuParams setMenuItem(SysMenu sysMenu) {
        SysMenuParams sysMenuParams = new SysMenuParams();
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
}
