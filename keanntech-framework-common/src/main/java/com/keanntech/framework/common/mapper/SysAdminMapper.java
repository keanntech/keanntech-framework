package com.keanntech.framework.common.mapper;

import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.model.SysAdminExample;
import com.keanntech.framework.common.model.SysAdminKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    long countByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int deleteByPrimaryKey(SysAdminKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insert(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int insertSelective(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    List<SysAdmin> selectByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    SysAdmin selectByPrimaryKey(SysAdminKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysAdmin record, @Param("example") SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByExample(@Param("record") SysAdmin record, @Param("example") SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKeySelective(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated Wed Jun 24 08:38:58 CST 2020
     */
    int updateByPrimaryKey(SysAdmin record);
}