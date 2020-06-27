package com.keanntech.framework.admin.controller;

import com.google.gson.Gson;
import com.keanntech.framework.admin.dto.SysAdminParams;
import com.keanntech.framework.admin.dto.SysAdminUserDetails;
import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.admin.service.SysMenuService;
import com.keanntech.framework.common.api.CommonResult;
import com.keanntech.framework.common.api.ResultCode;
import com.keanntech.framework.common.model.SysAdmin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "AdminController")
@RequestMapping("/admin")
@RestController
public class SysAdminController {

    @Value("${jwt.tokenHeader:Authorization}")
    private String tokenHeader;
    @Value("${jwt.tokenHead:Bearer}")
    private String tokenHead;

    @Autowired
    SysAdminService sysAdminService;

    @Autowired
    SysMenuService sysMenuService;

    @ApiOperation(value = "登录成功后返回token")
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody @Validated SysAdminParams sysAdminParams, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Gson errJson = new Gson();
            String strErrJson = errJson.toJson(bindingResult.getAllErrors());
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, strErrJson);
        }
        String token = null;
        try {
            token = sysAdminService.login(sysAdminParams.getUsername(), sysAdminParams.getPassword());
            if (StringUtils.isEmpty(token)) {
                return CommonResult.validateFailed("用户名或密码错误");
            }
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


    @ApiOperation(value = "获取当前登录用户")
    @GetMapping("/getCurrentAdminInfo")
    public CommonResult getCurrentAdminInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return CommonResult.unauthorized(null);
            }

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                SysAdminUserDetails sysAdminUserDetails = (SysAdminUserDetails) authentication.getPrincipal();
                SysAdmin sysAdmin = sysAdminService.getAdminByUsername(sysAdminUserDetails.getUsername());
                List<SysMenuParams> menuTree = sysMenuService.getMenuTree(sysAdmin.getId());
                Map<String, Object> data = new HashMap<>(4);
                data.put("username", sysAdmin.getUsername());
                data.put("id", sysAdmin.getId());
                data.put("portrait", sysAdmin.getPortrait());
                data.put("menus", menuTree);
                return CommonResult.success(data);
            }
        }
        return CommonResult.unauthorized(null);
    }
}
