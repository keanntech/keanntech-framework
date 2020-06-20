package com.keanntech.framework.admin.service;

import com.keanntech.framework.common.model.UmsAdmin;
import com.keanntech.framework.common.model.UmsResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UmsAdminService {

    UmsAdmin getAdminByUsername(String userName);

    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);

    UserDetails loadUserByUsername(String userName);

}
