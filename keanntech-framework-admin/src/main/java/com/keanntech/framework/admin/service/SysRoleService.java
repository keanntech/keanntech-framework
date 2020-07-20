package com.keanntech.framework.admin.service;

import com.keanntech.framework.common.model.SysRole;

import java.text.ParseException;
import java.util.List;

public interface SysRoleService {

    List<SysRole> getAllRole();
    boolean saveRole(SysRole sysRole) throws ParseException;
    int updateRole(SysRole sysRole) ;

}
