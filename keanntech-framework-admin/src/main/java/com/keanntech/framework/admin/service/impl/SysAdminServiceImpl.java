package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.dto.SysAdminUserDetails;
import com.keanntech.framework.admin.mapper.AdminRoleResourceMapper;
import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.common.mapper.SysAdminMapper;
import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.model.SysAdminExample;
import com.keanntech.framework.common.model.SysResource;
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
public class SysAdminServiceImpl implements SysAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysAdminServiceImpl.class);

    @Autowired
    SysAdminMapper sysAdminMapper;

    @Autowired
    AdminRoleResourceMapper adminRoleResourceMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public SysAdmin getAdminByUsername(String userName) {
        SysAdminExample adminExample = new SysAdminExample();
        adminExample.createCriteria().andUsernameEqualTo(userName);
        List<SysAdmin> umsAdminList = sysAdminMapper.selectByExample(adminExample);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public List<SysResource> getResourceList(Long adminId) {
        return adminRoleResourceMapper.getResourceList(adminId);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        SysAdmin umsAdmin = getAdminByUsername(userName);
        if (umsAdmin != null) {
            List<SysResource> resourceList = getResourceList(umsAdmin.getId());
            return new SysAdminUserDetails(umsAdmin, resourceList);
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