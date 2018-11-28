package com.cun.module.sys.service;

import com.cun.module.sys.entity.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser findByUsernameAndPassword(String username, String password);

    List<SysUser> getAllSysUsers();

}
