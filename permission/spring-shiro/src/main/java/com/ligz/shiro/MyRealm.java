package com.ligz.shiro;

import com.ligz.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义的 Realm
 * author:ligz
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Set<String> roles = new HashSet<>();
        roles.add("admin");
        authorizationInfo.setRoles(roles);

        Set<String> permissions = new HashSet<>();
        permissions.add("add");
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        User user = selectUserByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes("TestSalt"), super.getName());
    }

    /**
     * 仿照数据库信息
     * @param username
     * @return
     */
    private User selectUserByUserName(String username) {
        if ("ligz".equals(username)) {
            //return new User(username, "123456");
            return new User(username, "e5f728a966d050296c428290c9160dda");//这个是123456加上TestSalt盐后的值
        }
        return null;
    }
}
