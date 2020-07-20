package com.keanntech.framework.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baidu.fsg.uid.UidGenerator;
import com.keanntech.framework.admin.dto.SysAdminUserDetails;
import com.keanntech.framework.admin.service.SysAdminService;
import com.keanntech.framework.admin.service.SysRoleService;
import com.keanntech.framework.admin.util.AdminUtil;
import com.keanntech.framework.common.mapper.SysRoleMapper;
import com.keanntech.framework.common.model.SysAdmin;
import com.keanntech.framework.common.model.SysRole;
import com.keanntech.framework.common.model.SysRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Resource
    UidGenerator uidGenerator;

    @Autowired
    SysAdminService sysAdminService;

    @Override
    public List<SysRole> getAllRole() {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.setOrderByClause("sort ASC");
        return sysRoleMapper.selectByExample(sysRoleExample);
    }

    @Override
    public boolean saveRole(SysRole sysRole) throws ParseException {
        SysAdminUserDetails sysAdminUserDetails = AdminUtil.getCurrentAdmin();
        SysAdmin sysAdmin = sysAdminService.getAdminByUsername(sysAdminUserDetails.getUsername());
        Long uid = uidGenerator.getUID();
        sysRole.setId(uid);
        sysRole.setCreateId(sysAdmin.getId());
        sysRole.setUpdateId(sysAdmin.getId());
        sysRole.setCreateTime(df.parse(DateUtil.now()));
        sysRole.setUpdateTime(df.parse(DateUtil.now()));
        return sysRoleMapper.insert(sysRole) > 0 ? true : false;
    }

    @Override
    public int updateRole(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }
}
