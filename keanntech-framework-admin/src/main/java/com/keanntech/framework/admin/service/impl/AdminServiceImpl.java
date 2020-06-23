package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.dto.AdminUserDetails;
import com.keanntech.framework.admin.mapper.AdminRoleResourceRelationMapper;
import com.keanntech.framework.admin.service.AdminService;
import com.keanntech.framework.common.mapper.AdminMapper;
import com.keanntech.framework.common.model.Admin;
import com.keanntech.framework.common.model.AdminExample;
import com.keanntech.framework.common.model.Resource;
import com.keanntech.framework.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    AdminRoleResourceRelationMapper adminRoleResourceRelationMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Admin getAdminByUsername(String userName) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(userName);
        List<Admin> umsAdminList = adminMapper.selectByExample(adminExample);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        return adminRoleResourceRelationMapper.getResourceList(adminId);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Admin umsAdmin = getAdminByUsername(userName);
        if (umsAdmin != null) {
            List<Resource> resourceList = getResourceList(umsAdmin.getId());
            return new AdminUserDetails(umsAdmin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public String login(String userName, String passWord) {
        String token = null;
        UserDetails userDetails = loadUserByUsername(userName);
        if (userDetails == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (!passwordEncoder.matches(passWord, userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn(e.getMessage());
        }
        return token;
    }
}