package com.cun.module.sys.service;

import com.cun.module.sys.entity.SysPermission;

import java.util.List;
import java.util.Set;

public interface SysPermissionService {

    List<SysPermission> queryAll();

    Set<String> getSysPermissionByUserId(Integer id);

}
