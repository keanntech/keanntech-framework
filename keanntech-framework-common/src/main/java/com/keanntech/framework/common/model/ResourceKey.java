package com.keanntech.framework.common.model;

import java.io.Serializable;

public class ResourceKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource.id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource.id
     *
     * @return the value of resource.id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource.id
     *
     * @param id the value for resource.id
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource
     *
     * @mbg.generated Tue Jun 23 09:06:40 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}