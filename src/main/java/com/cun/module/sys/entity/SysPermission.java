package com.cun.module.sys.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "sys_permission")
@Entity
public class SysPermission {

    @ApiModelProperty("主键、自增")
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty("权限名")
    @Column(name = "permission_name",length = 20) // 菜单名
    private String permissionName;

    @ApiModelProperty("权限链接")
    @Column(name = "permission_url",length = 200) // 请求接口 url
    private String permissionUrl;

}
