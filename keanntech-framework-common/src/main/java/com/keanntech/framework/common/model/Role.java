package com.keanntech.framework.common.model;

import java.io.Serializable;
import java.util.Date;

public class Role extends RoleKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_code
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private String roleCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.description
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.sort
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Long createId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Long updateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_time
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.enable
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Boolean enable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.deleted
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_code
     *
     * @return the value of role.role_code
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_code
     *
     * @param roleCode the value for role.role_code
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.description
     *
     * @return the value of role.description
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.description
     *
     * @param description the value for role.description
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.sort
     *
     * @return the value of role.sort
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.sort
     *
     * @param sort the value for role.sort
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_id
     *
     * @return the value of role.create_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_id
     *
     * @param createId the value for role.create_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_id
     *
     * @return the value of role.update_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_id
     *
     * @param updateId the value for role.update_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_time
     *
     * @param createTime the value for role.create_time
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_time
     *
     * @return the value of role.update_time
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_time
     *
     * @param updateTime the value for role.update_time
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.enable
     *
     * @return the value of role.enable
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.enable
     *
     * @param enable the value for role.enable
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.deleted
     *
     * @return the value of role.deleted
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.deleted
     *
     * @param deleted the value for role.deleted
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleName=").append(roleName);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", description=").append(description);
        sb.append(", sort=").append(sort);
        sb.append(", createId=").append(createId);
        sb.append(", updateId=").append(updateId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", enable=").append(enable);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}