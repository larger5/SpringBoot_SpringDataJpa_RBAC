package com.cun.config.interceptor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cun.exception.RBACException;
import com.cun.module.sys.entity.SysPermission;
import com.cun.module.sys.service.SysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 获取用户的请求地址
        String requestURI = request.getRequestURI();
        logger.info(this.getClass().getName() + " 请求的 URI：" + requestURI);

        // 查询所有需要验证的路径集合
        List<SysPermission> sysPermissions = sysPermissionService.queryAll();

        Set<String> uriSet = new HashSet<String>();
        for (SysPermission sysPermission : sysPermissions) {
            if (sysPermission.getPermissionUrl() != null && !"".equals(sysPermission.getPermissionUrl())) {
                uriSet.add(sysPermission.getPermissionUrl());
            }
        }
        logger.info(this.getClass().getName() + " 需要授权的全部 URI：" + uriSet);

        // 判断当前路径是否需要进行权限验证。
        if (uriSet.contains(requestURI)) {
            logger.info(this.getClass().getName() + " URI 需要进行权限验证");
            // 判断当前用户是否拥有对应的权限
            Set<String> authUriSet = (Set<String>) request.getSession().getAttribute("authUriSet");
            logger.info(this.getClass().getName() + " 当前角色拥有的权限：" + authUriSet);
            if (authUriSet.contains(requestURI)) {
                logger.info(this.getClass().getName() + " 认证通过，放过");
                // 认证通过，放过
                return true;
            } else {
                logger.info(this.getClass().getName() + " 认证未通过，拦截");
                throw new RBACException("权限认证未通过，拦截");
                // 抛出异常优化前后端交互，同时下面得注释掉
//                return false;
            }
        } else {
            // 不要认证，直接放过
            logger.info(this.getClass().getName() + " URI 不需要认证，直接放过");
            return true;
        }
    }

}
