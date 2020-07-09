package com.keanntech.framework.admin.controller;

import com.google.gson.Gson;
import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.admin.service.SysMenuService;
import com.keanntech.framework.common.api.CommonResult;
import com.keanntech.framework.common.api.ResultCode;
import com.keanntech.framework.common.exception.ApiException;
import com.keanntech.framework.common.exception.UserNotLoginException;
import com.keanntech.framework.common.model.SysMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api(tags = "SysMenuController")
@RequestMapping("/admin/sysmenu")
@RestController
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @ApiOperation(value = "根据ID获取所拥有的菜单，用于侧边栏菜单展示")
    @GetMapping("/loadMenuTree/{adminId}")
    public CommonResult loadMenuTree(@ApiParam(name = "adminId", required = true) @PathVariable("adminId") Long adminId) {
        List<SysMenuParams> menuTree = sysMenuService.getMenuTree(adminId);
        return CommonResult.success(menuTree);
    }

    @ApiOperation(value = "加载全部菜单")
    @GetMapping("/loadAllMenu/{parentId}")
    public CommonResult loadAllMenu(@ApiParam(name = "parentId", required = true) @PathVariable("parentId") Long parentId) {
        List<SysMenu> menuTree = sysMenuService.getChildrenMenu(parentId);
        return CommonResult.success(menuTree);
    }

    @ApiOperation(value = "保存菜单")
    @PostMapping("/saveSysMenu")
    @ResponseBody
    public CommonResult saveSysMenu(@RequestBody @Validated SysMenu sysMenu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Gson errJson = new Gson();
            String strErrJson = errJson.toJson(bindingResult.getAllErrors());
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, strErrJson);
        }

        try {
            if(sysMenuService.saveMenu(sysMenu)) {
                return CommonResult.success(sysMenu);
            }
        } catch (ParseException e) {
            return CommonResult.failed("保存失败");
        } catch (ApiException e) {
            return CommonResult.failed(e.getMessage());
        } catch (UserNotLoginException e) {
            return CommonResult.unauthorized(null);
        }
        return CommonResult.failed("保存失败");
    }

    @ApiOperation(value = "修改菜单")
    @PostMapping("/updateSysMenu")
    @ResponseBody
    public CommonResult updateSysMenu(@RequestBody @Validated SysMenu sysMenu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Gson errJson = new Gson();
            String strErrJson = errJson.toJson(bindingResult.getAllErrors());
            return CommonResult.failed(ResultCode.VALIDATE_FAILED, strErrJson);
        }

        try {
            return sysMenuService.updateMenu(sysMenu) > 0 ? CommonResult.success(null) : CommonResult.failed("更新失败");
        } catch (ParseException e) {
            return CommonResult.failed("更新失败");
        } catch (ApiException e) {
            return CommonResult.failed(e.getMessage());
        } catch (UserNotLoginException e) {
            return CommonResult.unauthorized(null);
        }
    }

    @ApiOperation(value = "删除菜单")
    @GetMapping("/delSysMenu/{menuId}")
    public CommonResult delSysMenu(@PathVariable("menuId") Long menuId) {
        List<SysMenu> sysMenuList = sysMenuService.getChildrenMenu(menuId);
        if(sysMenuList != null && sysMenuList.size() > 0) {
            return CommonResult.failed("此菜单含有子菜单，请先删除子菜单");
        }
        return sysMenuService.delMenu(menuId) > 0 ? CommonResult.success(null) : CommonResult.failed("删除失败");
    }

}
