package com.cun.module.sys.service.impl;

import com.cun.module.sys.repository.SysRoleRepository;
import com.cun.module.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

}
