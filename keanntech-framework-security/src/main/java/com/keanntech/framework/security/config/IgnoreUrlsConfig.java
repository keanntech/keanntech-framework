package com.keanntech.framework.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "ignored")
public class IgnoreUrlsConfig {

    private List<String> authUrls = new ArrayList<>();

    public void setAuthUrls(List<String> urls) {
        this.authUrls = urls;
    }

    public List<String> getAuthUrls() {
        return this.authUrls;
    }

}
