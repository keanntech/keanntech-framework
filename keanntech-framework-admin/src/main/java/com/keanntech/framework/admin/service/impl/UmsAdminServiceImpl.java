package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.dto.AdminUserDetails;
import com.keanntech.framework.admin.mapper.UmsAdminRoleRelationMapper;
import com.keanntech.framework.admin.service.UmsAdminService;
import com.keanntech.framework.common.mapper.UmsAdminMapper;
import com.keanntech.framework.common.model.UmsAdmin;
import com.keanntech.framework.common.model.UmsAdminExample;
import com.keanntech.framework.common.model.UmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    UmsAdminMapper umsAdminMapper;

    @Autowired
    UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    @Override
    public UmsAdmin getAdminByUsername(String userName) {
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(userName);
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(umsAdminExample);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return umsAdminRoleRelationMapper.getResourceList(adminId);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        UmsAdmin umsAdmin = getAdminByUsername(userName);
        if (umsAdmin != null) {
            List<UmsResource> resourceList = getResourceList(umsAdmin.getId());
            return new AdminUserDetails(umsAdmin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}