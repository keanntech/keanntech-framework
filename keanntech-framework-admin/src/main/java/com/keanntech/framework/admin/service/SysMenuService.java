package com.keanntech.framework.admin.service;

import com.keanntech.framework.admin.dto.SysMenuParams;
import com.keanntech.framework.common.model.SysMenu;

import java.text.ParseException;
import java.util.List;

public interface SysMenuService {

    List<SysMenu> getAllSysMenu();
    List<SysMenu> getAllSysMenu(Long adminId);
    List<SysMenu> getChildrenMenu(Long parentId);

    List<SysMenuParams> getMenuTree(Long adminId);

    boolean saveMenu(SysMenu sysMenu) throws ParseException;

    int updateMenu(SysMenu sysMenu) throws ParseException;

    int delMenu(Long menuId);

}
