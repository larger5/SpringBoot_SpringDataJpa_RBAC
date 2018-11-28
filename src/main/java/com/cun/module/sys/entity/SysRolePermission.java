package com.cun.module.sys.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermission {

    @ApiModelProperty("主键、自增")
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty("角色id")
    @ManyToOne
    @JoinColumn(name = "sys_role_id")
    private SysRole sysRole; // 角色

    @ApiModelProperty("权限id")
    @ManyToOne
    @JoinColumn(name = "sys_permission_id")
    private SysPermission sysPermission; // 权限

}
