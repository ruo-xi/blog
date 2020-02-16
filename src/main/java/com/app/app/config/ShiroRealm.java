package com.app.app.config;

import com.app.app.entity.JWTToken;
import com.app.app.entity.User;
import com.app.app.service.UserService;
import com.app.app.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    /**
     * 授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("逻辑授权");
        return null;
    }


    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JWTToken;
    }


    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {

        String token = (String) auth.getCredentials();
        Integer userId = JWTUtil.getUserId(token);

        log.info("用户:" + userId + " 认证-----ShiroRealm.doGetAuthenticationInfo");

        if (userId == 0) {
            throw new AuthenticationException("token invalid");
        }


        User userBean = userService.getUserById(userId);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.vertify(token, userId, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
