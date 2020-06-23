package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.service.ResourceService;
import com.keanntech.framework.common.mapper.ResourceMapper;
import com.keanntech.framework.common.model.Resource;
import com.keanntech.framework.common.model.ResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public List<Resource> listAll() {
        return resourceMapper.selectByExample(new ResourceExample());
    }
}
