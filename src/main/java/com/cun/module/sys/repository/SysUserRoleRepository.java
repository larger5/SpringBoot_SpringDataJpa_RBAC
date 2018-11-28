package com.cun.module.sys.repository;

import com.cun.module.sys.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Integer>, JpaSpecificationExecutor<SysUserRole> {

    List<SysUserRole> findAllBySysUser_Id(Integer id);

}
