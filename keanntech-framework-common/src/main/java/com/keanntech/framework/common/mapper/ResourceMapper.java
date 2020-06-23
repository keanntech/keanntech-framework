package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.Resource;
import com.keanntech.framework.common.model.ResourceExample;
import com.keanntech.framework.common.model.ResourceKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    long countByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int deleteByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int deleteByPrimaryKey(ResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    Resource selectByPrimaryKey(ResourceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    int updateByPrimaryKey(Resource record);
}