package com.cun.module.home;

import com.cun.module.sys.entity.SysUser;
import com.cun.module.sys.service.SysPermissionService;
import com.cun.module.sys.service.SysUserService;
import com.cun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * 失败情况已经在 Service 层中处理，使用 Exception
 */
@Api(tags = "首页 | 用户登录")
@RestController
@RequestMapping("/home")
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "用户登录接口", notes = "")
    @PostMapping("/login")
    public R login(String username, String password, HttpServletRequest request) {
        SysUser sysUser = sysUserService.findByUsernameAndPassword(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", sysUser);
        Set<String> authUriSet = sysPermissionService.getSysPermissionByUserId(sysUser.getId());
        session.setAttribute("authUriSet", authUriSet);
        logger.info(this.getClass().getName() + " 登录成功");
        logger.info(this.getClass().getName() + " 登录用户：" + sysUser);
        logger.info(this.getClass().getName() + " 用户权限：" + authUriSet);
        return R.success(sysUser);
    }

    @ApiOperation(value = "用户注销接口", notes = "")
    @DeleteMapping("/logout")
    public R logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("loginUser");
        session.removeAttribute("loginUser");
        logger.info(this.getClass().getName() + " 注销成功");
        logger.info(this.getClass().getName() + " 注销用户：" + sysUser);
        return R.success(sysUser);
    }

}
