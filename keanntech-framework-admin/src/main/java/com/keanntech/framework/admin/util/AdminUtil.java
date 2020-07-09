package com.keanntech.framework.admin.util;

import com.keanntech.framework.admin.dto.SysAdminUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdminUtil {

    public static SysAdminUserDetails getCurrentAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        if(authentication instanceof UsernamePasswordAuthenticationToken) {
            return (SysAdminUserDetails) authentication.getPrincipal();
        }
        return null;
    }

}
