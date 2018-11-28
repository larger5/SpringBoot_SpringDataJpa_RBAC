package com.cun.module.sys.service.impl;

import com.cun.exception.RBACException;
import com.cun.module.sys.entity.SysUser;
import com.cun.module.sys.repository.SysUserRepository;
import com.cun.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findByUsernameAndPassword(String username, String password) {
        SysUser sysUser = sysUserRepository.findByUsernameAndPassword(username, password);
        if (sysUser == null) {
            throw new RBACException("用户不存在");
        }
        return sysUser;
    }

    @Override
    public List<SysUser> getAllSysUsers() {
        return sysUserRepository.findAll();
    }
}
