package com.cun.module.sys.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_user")
public class SysUser {

    @ApiModelProperty("主键、自增")
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty("用户名")
    @Column(name = "username",length = 20)
    private String username;

    @ApiModelProperty("密码")
    @Column(name = "password",length =100) // 若 md5 加密，长度要足够
    private String password;

}
