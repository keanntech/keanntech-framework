package com.keanntech.framework.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {
                "com.keanntech.framework.common",
                "com.keanntech.framework.admin",
                "com.keanntech.framework.uidgenerator"
        }
)
@MapperScan(
        basePackages = {
                "com.keanntech.framework.common.mapper",
                "com.keanntech.framework.admin.mapper",
                "com.keanntech.framework.uidgenerator.mapper"
        }
)
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
