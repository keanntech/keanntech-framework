package com.keanntech.framework.admin.controller;

import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.admin.service.SysMenuService;
import com.keanntech.framework.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SysMenuController")
@RequestMapping("/admin")
@RestController
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @GetMapping("/loadMenuTree/{adminId}")
    public CommonResult loadMenuTree(@ApiParam(name = "adminId", required = true) @PathVariable("adminId") Long adminId) {
        List<SysMenuParams> menuTree = sysMenuService.getMenuTree(adminId);
        return CommonResult.success(menuTree);
    }

}
