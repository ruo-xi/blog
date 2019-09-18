package com.app.app.config;

import com.app.app.dao.UserMapper;
import com.app.app.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    /**
    *授权
    **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String userPsw = new String((char[])  token.getCredentials());

        System.out.println("用户:" + userName + " 认证-----ShiroRealm.doGetAuthenticationInfo");

        User user = userMapper.getUserByName(userName);

        if(null == user){
            throw new UnknownAccountException("用户名或密码错误");
        }
        if(!userPsw.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,userPsw,getName());

        return info;
    }
}
