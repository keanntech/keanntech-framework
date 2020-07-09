package com.keanntech.framework.admin.mapper;

import com.keanntech.framework.common.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminRoleMenuMapper {

    /**
     * 获取菜单列表<br/>
     * adminId = 0 则不区分用户<br/>
     * parentId < 0 则加载全部
     * @param adminId
     * @return
     */
    List<SysMenu> getSysMenuList(@Param("adminId") Long adminId);

}
