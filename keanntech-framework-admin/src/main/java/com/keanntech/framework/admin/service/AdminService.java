package com.keanntech.framework.admin.service;

import com.keanntech.framework.common.model.Admin;
import com.keanntech.framework.common.model.Resource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AdminService {

    Admin getAdminByUsername(String userName);

    /**
     * 获取指定用户的可访问资源
     */
    List<Resource> getResourceList(Long adminId);

    UserDetails loadUserByUsername(String userName);

    String login(String userName, String passWord);

}
