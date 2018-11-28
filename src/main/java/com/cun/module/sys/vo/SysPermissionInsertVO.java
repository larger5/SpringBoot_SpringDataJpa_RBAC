package com.cun.module.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysPermissionInsertVO {

    @ApiModelProperty("权限名")
    private String permissionName;

    @ApiModelProperty("权限链接")
    private String permissionUrl;

}
