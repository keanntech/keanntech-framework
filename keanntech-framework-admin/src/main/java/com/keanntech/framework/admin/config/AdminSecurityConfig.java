package com.keanntech.framework.admin.config;

import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.admin.service.SysResourceService;
import com.keanntech.framework.common.model.SysResource;
import com.keanntech.framework.security.DynamicSecurityService;
import com.keanntech.framework.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends SecurityConfig {

    @Autowired
    SysAdminService sysAdminService;

    @Autowired
    SysResourceService sysResourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> sysAdminService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<SysResource> resourceList = sysResourceService.listAll();
                for (SysResource resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getResourceName()));
                }
                return map;
            }
        };
    }


}
