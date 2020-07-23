package com.keanntech.framework.admin.controller;

import com.google.gson.Gson;
import com.keanntech.framework.admin.service.SysRoleService;
import com.keanntech.framework.common.api.CommonResult;
import com.keanntech.framework.common.api.ResultCode;
import com.keanntech.framework.common.model.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@Api(value = "SysRoleController", tags = {"角色接口"})
@RequestMapping("/admin/role")
@RestController
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @ApiOperation(value = "获取全部角色")
    @RequestMapping("/loadAllRole")
    public CommonResult loadAllRole() {
        List<SysRole> sysRoles = sysRoleService.getAllRole();
        return CommonResult.success(sysRoles);
    }

    @ApiOperation(value = "保存角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRole", value = "角色实体类", required = true, paramType = "form")
    })
    @RequestMapping("/saveRole")
    @ResponseBody
    public CommonResult saveRole(@RequestBody @Validated SysRole sysRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Gson errJson = new Gson();
            String strErrJson = errJson.toJson(bindingResult.getAllErrors());
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, strErrJson);
        }

        try {
            sysRoleService.saveRole(sysRole);
            return CommonResult.success(sysRole);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return CommonResult.failed("保存失败");
    }

    @ApiOperation(value = "更新角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRole", value = "角色实体类", required = true, paramType = "form")
    })
    @RequestMapping("/updateRole")
    @ResponseBody
    public CommonResult updateRole(@RequestBody @Validated SysRole sysRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Gson errJson = new Gson();
            String strErrJson = errJson.toJson(bindingResult.getAllErrors());
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, strErrJson);
        }

        try {
            sysRoleService.updateRole(sysRole);
            return CommonResult.success(sysRole);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return CommonResult.failed("更新失败");
    }

}
