package com.keanntech.framework.admin.service.impl;

import com.keanntech.framework.admin.service.UmsResourceService;
import com.keanntech.framework.common.mapper.UmsResourceMapper;
import com.keanntech.framework.common.model.UmsResource;
import com.keanntech.framework.common.model.UmsResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    UmsResourceMapper umsResourceMapper;

    @Override
    public List<UmsResource> listAll() {
        return umsResourceMapper.selectByExample(new UmsResourceExample());
    }
}
