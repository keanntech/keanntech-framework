package com.keanntech.framework.admin.mapper;

import com.keanntech.framework.common.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminRoleMenuMapper {

    List<SysMenu> getSysMenuList(@Param("adminId") Long adminId);

}
