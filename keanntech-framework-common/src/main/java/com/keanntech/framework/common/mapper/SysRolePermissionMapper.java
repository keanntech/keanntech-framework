package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.SysRolePermission;
import com.keanntech.framework.common.model.SysRolePermissionExample;
import com.keanntech.framework.common.model.SysRolePermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    long countByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int deleteByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int deleteByPrimaryKey(SysRolePermissionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int insert(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int insertSelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    SysRolePermission selectByPrimaryKey(SysRolePermissionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Fri Jun 26 21:54:50 CST 2020
     */
    int updateByPrimaryKey(SysRolePermission record);
}