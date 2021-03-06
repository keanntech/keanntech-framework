package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.SysRoleAdmin;
import com.keanntech.framework.common.model.SysRoleAdminExample;
import com.keanntech.framework.common.model.SysRoleAdminKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    long countByExample(SysRoleAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByExample(SysRoleAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByPrimaryKey(SysRoleAdminKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insert(SysRoleAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insertSelective(SysRoleAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    List<SysRoleAdmin> selectByExample(SysRoleAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    SysRoleAdmin selectByPrimaryKey(SysRoleAdminKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRoleAdmin record, @Param("example") SysRoleAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExample(@Param("record") SysRoleAdmin record, @Param("example") SysRoleAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKeySelective(SysRoleAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKey(SysRoleAdmin record);
}