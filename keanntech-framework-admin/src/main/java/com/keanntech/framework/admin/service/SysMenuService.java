package com.keanntech.framework.admin.service;

import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.common.model.SysMenu;

import java.util.List;

public interface SysMenuService {

    List<SysMenu> getSysMenuList(Long adminId);

    List<SysMenuParams> getMenuTree(Long adminId);

}
