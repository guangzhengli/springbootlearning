package com.ligz.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:ligz
 */
@RestController
public class AuthorizationController {

    @RequestMapping("/role1")
    @RequiresRoles("user")
    public String role1() {
        return "success";
    }

    @RequestMapping("/role2")
    @RequiresRoles("admin")
    public String role2() {
        return "success2";
    }

    /**
     * 访问 role1 方法需要当前用户有 user 角色，role2 方法需要 admin 角色。
     * 当验证失败时，会抛出 UnauthorizedException,我们可以使用 Spring 的 ExceptionHandler 来进行异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String processUnauthorizedException(UnauthorizedException e) {
        return e.getMessage();
    }
}
