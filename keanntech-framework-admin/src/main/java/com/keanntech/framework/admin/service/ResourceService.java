package com.keanntech.framework.admin.service;

import com.keanntech.framework.common.model.Resource;

import java.util.List;

public interface ResourceService {

    /**
     * 查询全部资源
     */
    List<Resource> listAll();

}
