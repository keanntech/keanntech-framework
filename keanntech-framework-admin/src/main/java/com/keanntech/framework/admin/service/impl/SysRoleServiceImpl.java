package com.keanntech.framework.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.admin.service.SysRoleService;
import com.keanntech.framework.admin.util.AdminUtil;
import com.keanntech.framework.common.exception.ApiException;
import com.keanntech.framework.common.mapper.SysRoleMapper;
import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.model.SysRole;
import com.keanntech.framework.common.model.SysRoleExample;
import com.keanntech.framework.common.util.UidGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysAdminService sysAdminService;

    /**
     * 获取全部角色
     * @return
     */
    @Override
    public List<SysRole> getAllRole() {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.setOrderByClause("sort ASC");
        return sysRoleMapper.selectByExample(sysRoleExample);
    }

    /**
     * 保存角色
     * @param sysRole
     * @return
     * @throws ParseException
     */
    @Override
    public boolean saveRole(SysRole sysRole) throws ParseException {
        if(roleNameIsExist(sysRole, false)) {
            throw new ApiException("角色名称重复");
        }
        if(roleCodeIsExist(sysRole, false)) {
            throw new ApiException("角色编码重复");
        }
        SysAdmin sysAdmin = AdminUtil.getCurrentAdmin();
        sysRole.setId(UidGeneratorUtil.getUid());
        sysRole.setCreateId(sysAdmin.getId());
        sysRole.setUpdateId(sysAdmin.getId());
        sysRole.setCreateTime(threadLocal.get().parse(DateUtil.now()));
        sysRole.setUpdateTime(threadLocal.get().parse(DateUtil.now()));
        sysRole.setDeleted(false);
        return sysRoleMapper.insert(sysRole) > 0 ? true : false;
    }

    /**
     * 更新角色
     * @param sysRole
     * @return
     * @throws ParseException
     */
    @Override
    public int updateRole(SysRole sysRole) throws ParseException{
        if(roleNameIsExist(sysRole, true)) {
            throw new ApiException("角色名称重复");
        }
        if(roleCodeIsExist(sysRole, true)) {
            throw new ApiException("角色编码重复");
        }
        SysAdmin sysAdmin = AdminUtil.getCurrentAdmin();
        sysRole.setUpdateId(sysAdmin.getId());
        sysRole.setUpdateTime(threadLocal.get().parse(DateUtil.now()));
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * 判断角色名是否已存在<br/>
     * 如果isUpdate为true，则排除自已本身查询是否有重复名称
     * @param sysRole
     * @param isUpdate
     * @return
     */
    private boolean roleNameIsExist(SysRole sysRole, boolean isUpdate) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = sysRoleExample.createCriteria().andRoleNameEqualTo(sysRole.getRoleName());
        if(isUpdate) {
            criteria.andIdNotEqualTo(sysRole.getId());
        }
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        return sysRoles != null && sysRoles.size() > 0 ? true : false;
    }

    /**
     * 判断角色编码是否已存在
     * 如果isUpdate为true，则排除自已本身查询是否有重复编码
     * @param sysRole
     * @param isUpdate
     * @return
     */
    private boolean roleCodeIsExist(SysRole sysRole, boolean isUpdate) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = sysRoleExample.createCriteria().andRoleCodeEqualTo(sysRole.getRoleCode());
        if(isUpdate) {
            criteria.andIdNotEqualTo(sysRole.getId());
        }
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        return sysRoles != null && sysRoles.size() > 0 ? true : false;
    }
}
