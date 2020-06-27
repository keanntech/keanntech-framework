package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.service.SysResourceService;
import com.keanntech.framework.common.mapper.SysResourceMapper;
import com.keanntech.framework.common.model.SysResource;
import com.keanntech.framework.common.model.SysResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> listAll() {
        return sysResourceMapper.selectByExample(new SysResourceExample());
    }
}
