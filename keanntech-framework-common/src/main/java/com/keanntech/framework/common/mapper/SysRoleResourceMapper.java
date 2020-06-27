package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.SysRoleResource;
import com.keanntech.framework.common.model.SysRoleResourceExample;
import com.keanntech.framework.common.model.SysRoleResourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    long countByExample(SysRoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByExample(SysRoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByPrimaryKey(SysRoleResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insert(SysRoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insertSelective(SysRoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    List<SysRoleResource> selectByExample(SysRoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    SysRoleResource selectByPrimaryKey(SysRoleResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExample(@Param("record") SysRoleResource record, @Param("example") SysRoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKeySelective(SysRoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKey(SysRoleResource record);
}