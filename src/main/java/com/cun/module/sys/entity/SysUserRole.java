package com.cun.module.sys.entity;

import com.cun.module.sys.entity.SysRole;
import com.cun.module.sys.entity.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_user_role")
public class SysUserRole {

    @ApiModelProperty("主键、自增")
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty("用户id")
    @ManyToOne
    @JoinColumn(name = "sys_user_id")
    private SysUser sysUser; // 用户

    @ApiModelProperty("角色id")
    @ManyToOne
    @JoinColumn(name = "sys_role_id")
    private SysRole sysRole; // 角色

}
