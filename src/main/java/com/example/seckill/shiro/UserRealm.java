package com.example.seckill.shiro;

import com.example.seckill.dao.SkUserDao;
import com.example.seckill.entity.SkUser;
import com.example.seckill.service.SkUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Date 2020/7/7 16:07
 * @Author mawkun
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    SkUserDao skUserDao;
    /**
     * 权限控制
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证控制
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();
        SkUser user = new SkUser();
        user.setNickname(name);
        user.setPassword(password);
        List<SkUser> list = skUserDao.getUserByNameAndPassWord(user);
        if(list.size() > 0) {
            return new SimpleAuthenticationInfo(name, password, "user");
        }
        return null;
    }
}
