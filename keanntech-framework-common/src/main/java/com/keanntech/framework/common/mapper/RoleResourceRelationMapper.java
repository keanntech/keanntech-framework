package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.RoleResourceRelation;
import com.keanntech.framework.common.model.RoleResourceRelationExample;
import com.keanntech.framework.common.model.RoleResourceRelationKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleResourceRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    long countByExample(RoleResourceRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int deleteByExample(RoleResourceRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int deleteByPrimaryKey(RoleResourceRelationKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int insert(RoleResourceRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int insertSelective(RoleResourceRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    List<RoleResourceRelation> selectByExample(RoleResourceRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    RoleResourceRelation selectByPrimaryKey(RoleResourceRelationKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByExampleSelective(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByExample(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByPrimaryKeySelective(RoleResourceRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByPrimaryKey(RoleResourceRelation record);
}