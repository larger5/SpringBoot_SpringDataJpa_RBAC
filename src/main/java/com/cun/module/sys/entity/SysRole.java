package com.cun.module.sys.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_role")
public class SysRole {

    @ApiModelProperty("主键、自增")
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty("角色名")
    @Column(name = "role_name",length = 20)
    private String roleName;

}
