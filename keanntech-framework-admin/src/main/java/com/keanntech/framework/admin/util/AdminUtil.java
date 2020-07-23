package com.keanntech.framework.admin.util;

import com.keanntech.framework.admin.dto.SysAdminUserDetails;
import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.common.exception.UserNotLoginException;
import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.util.SpringBeanUtil;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdminUtil {

    public static SysAdminUserDetails getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        if(authentication instanceof UsernamePasswordAuthenticationToken) {
            return (SysAdminUserDetails) authentication.getPrincipal();
        }
        return null;
    }

    public static SysAdmin getCurrentAdmin() {
        SysAdminUserDetails userDetails = getAuthentication();
        if(userDetails == null) {
            throw new UserNotLoginException("用户未登录");
        }
        SysAdminService sysAdminService = (SysAdminService) SpringBeanUtil.getBean("sysAdminService");
        return sysAdminService.getAdminByUsername(userDetails.getUsername());
    }

}
