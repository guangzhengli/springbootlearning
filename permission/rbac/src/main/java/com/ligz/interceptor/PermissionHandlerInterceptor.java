package com.ligz.interceptor;

import com.ligz.annotation.RequiredPermission;
import com.ligz.annotation.RequiredRole;
import com.ligz.model.Permission;
import com.ligz.model.Role;
import com.ligz.model.User;
import com.ligz.service.RoleService;
import com.ligz.service.UserService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * author:ligz
 */
public class PermissionHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        Method method = ((HandlerMethod) handler).getMethod();
        RequiredRole requiredRole = method.getAnnotation(RequiredRole.class);
        RequiredPermission requiredPermission = method.getAnnotation(RequiredPermission.class);
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.getWriter().write("未登录");
            return false;
        }


        List<Role> userRoles = userService.getUserRoles(user.getId());


        if (requiredRole != null) {
            for (Role role : userRoles) {
                if (role.getName().equals(requiredRole.value())) {
                    return true;
                }
            }
        }

        if (requiredPermission != null) {
            for (Role role : userRoles) {
                List<Permission> permissions = roleService.getPermissions(role.getId());
                for (Permission persission : permissions) {
                    if (requiredPermission.value().equals(persission.getName())) {
                        return true;
                    }
                }
            }
        }
        response.getWriter().println("你的权限不足");
        return false;
    }
}
