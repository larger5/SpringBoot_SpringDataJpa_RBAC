package com.cun.module.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
public class SysRoleInsertVO {

    @ApiModelProperty("主键、自增")
    private Integer id;

    @ApiModelProperty("角色名")
    private String roleName;

}
