package com.cun.module.sys.controller;

import com.cun.module.sys.service.SysUserService;
import com.cun.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "权限管理 | 用户")
@RestController
@RequestMapping("/admin/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/all")
    public R getAllSysUsers() {
        System.out.println("查询所有");
        return R.success(sysUserService.getAllSysUsers());
    }

}
