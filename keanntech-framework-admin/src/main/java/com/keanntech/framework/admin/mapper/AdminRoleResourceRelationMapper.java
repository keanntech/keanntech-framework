package com.keanntech.framework.admin.mapper;

import com.keanntech.framework.common.model.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminRoleResourceRelationMapper {

    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResourceList(@Param("adminId") Long adminId);


}
