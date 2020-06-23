package com.keanntech.framework.admin.controller;

import com.google.gson.Gson;
import com.keanntech.framework.admin.dto.AdminParams;
import com.keanntech.framework.admin.service.AdminService;
import com.keanntech.framework.common.api.CommonResult;
import com.keanntech.framework.common.api.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "AdminController")
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Value("${jwt.tokenHeader:Authorization}")
    private String tokenHeader;
    @Value("${jwt.tokenHead:Bearer}")
    private String tokenHead;

    @Autowired
    AdminService adminService;

    @ApiOperation(value = "登录成功后返回token")
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody @Validated AdminParams adminParams, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Gson errJson = new Gson();
            String strErrJson = errJson.toJson(bindingResult.getAllErrors());
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, strErrJson);
        }
        String token = null;
        try {
            token = adminService.login(adminParams.getUsername(), adminParams.getPassword());
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

}
