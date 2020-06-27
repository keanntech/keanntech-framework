package com.keanntech.framework.admin.dto;

import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.model.SysResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SysAdminUserDetails implements UserDetails {

    private SysAdmin sysAdmin;
    private List<SysResource> resourceList;

    public SysAdminUserDetails(SysAdmin admin, List<SysResource> resourceList) {
        this.sysAdmin = admin;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.resourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getResourceName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sysAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return sysAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return sysAdmin.getEnabled();
    }
}
