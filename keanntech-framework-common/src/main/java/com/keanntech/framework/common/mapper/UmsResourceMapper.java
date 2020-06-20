package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.UmsResource;
import com.keanntech.framework.common.model.UmsResourceExample;
import com.keanntech.framework.common.model.UmsResourceKey;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UmsResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    long countByExample(UmsResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int deleteByExample(UmsResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int deleteByPrimaryKey(UmsResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int insert(UmsResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int insertSelective(UmsResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    List<UmsResource> selectByExample(UmsResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    UmsResource selectByPrimaryKey(UmsResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") UmsResource record, @Param("example") UmsResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int updateByExample(@Param("record") UmsResource record, @Param("example") UmsResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int updateByPrimaryKeySelective(UmsResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_resource
     *
     * @mbg.generated Sat Jun 20 22:19:58 CST 2020
     */
    int updateByPrimaryKey(UmsResource record);
}