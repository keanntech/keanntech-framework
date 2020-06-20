package com.keanntech.framework.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "keanntech.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getUrls() {
        return this.urls;
    }

}
