package com.cun.module.sys.repository;

import com.cun.module.sys.entity.SysRolePermission;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission, Integer>, JpaSpecificationExecutor<SysRolePermission> {

    List<SysRolePermission> findAllBySysRole_Id(Integer id);

}
