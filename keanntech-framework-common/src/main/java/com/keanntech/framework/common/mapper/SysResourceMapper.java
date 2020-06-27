package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.SysResource;
import com.keanntech.framework.common.model.SysResourceExample;
import com.keanntech.framework.common.model.SysResourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    long countByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByPrimaryKey(SysResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insert(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insertSelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    List<SysResource> selectByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    SysResource selectByPrimaryKey(SysResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKey(SysResource record);
}