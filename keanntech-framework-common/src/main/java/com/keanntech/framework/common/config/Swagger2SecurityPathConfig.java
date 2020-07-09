package com.keanntech.framework.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "swagger2")
public class Swagger2SecurityPathConfig {

    private List<String> securityPath = new ArrayList<>();

    public List<String> getSecurityPath() {
        return securityPath;
    }

    public void setSecurityPath(List<String> securityPath) {
        this.securityPath = securityPath;
    }
}
