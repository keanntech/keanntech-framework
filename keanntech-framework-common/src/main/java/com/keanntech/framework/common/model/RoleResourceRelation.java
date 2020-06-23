package com.keanntech.framework.common.model;

import java.io.Serializable;

public class RoleResourceRelation extends RoleResourceRelationKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_resource_relation.role_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_resource_relation.resource_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Long resourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_resource_relation.role_id
     *
     * @return the value of role_resource_relation.role_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_resource_relation.role_id
     *
     * @param roleId the value for role_resource_relation.role_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_resource_relation.resource_id
     *
     * @return the value of role_resource_relation.resource_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_resource_relation.resource_id
     *
     * @param resourceId the value for role_resource_relation.resource_id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_relation
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}