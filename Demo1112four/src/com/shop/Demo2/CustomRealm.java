package com.shop.Demo2;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealm extends AuthorizingRealm {


    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 认证
     * @param Token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        /**
         * 凭证
         */
        //模拟从数据库查询出凭证
        String username = (String) Token.getPrincipal();//用户名
        String username_db="mayun";

        String password_db="a6b1420040aec1d208a25f893b0cde38";//密文
        int count=3;

        //盐
        String salt="abc";

        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, this.getName());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password_db, ByteSource.Util.bytes(salt),this.getName());
        return info;
    }
}
