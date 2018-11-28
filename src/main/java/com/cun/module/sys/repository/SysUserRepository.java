package com.cun.module.sys.repository;

import com.cun.module.sys.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserRepository extends JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {

    SysUser findByUsernameAndPassword(String username, String password);

}
