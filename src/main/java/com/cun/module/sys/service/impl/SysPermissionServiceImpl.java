package com.cun.module.sys.service.impl;

import com.cun.module.sys.entity.SysPermission;
import com.cun.module.sys.entity.SysRolePermission;
import com.cun.module.sys.entity.SysUserRole;
import com.cun.module.sys.repository.SysPermissionRepository;
import com.cun.module.sys.repository.SysRolePermissionRepository;
import com.cun.module.sys.repository.SysUserRepository;
import com.cun.module.sys.repository.SysUserRoleRepository;
import com.cun.module.sys.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;

    @Override
    public List<SysPermission> queryAll() {
        return sysPermissionRepository.findAll();
    }

    @Override
    public Set<String> getSysPermissionByUserId(Integer id) {

        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.findAllBySysUser_Id(id);

        Set<String> uriSet = new HashSet<String>();

        for (SysUserRole SysUserRole : sysUserRoleList) {
            List<SysRolePermission> sysRolePermissionList = sysRolePermissionRepository.findAllBySysRole_Id(SysUserRole.getSysRole().getId());
            for (SysRolePermission sysRolePermission : sysRolePermissionList) {
                SysPermission sysPermission = sysPermissionRepository.findOne(sysRolePermission.getSysPermission().getId());
                String permissionUrl = sysPermission.getPermissionUrl();
                uriSet.add(permissionUrl);
            }
        }
        return uriSet;
    }
}
