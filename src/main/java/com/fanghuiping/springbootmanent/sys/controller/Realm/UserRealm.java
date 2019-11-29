package com.fanghuiping.springbootmanent.sys.controller.Realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanghuiping.springbootmanent.common.ActiverUser;
import com.fanghuiping.springbootmanent.sys.domain.SysUser;
import com.fanghuiping.springbootmanent.sys.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        Qu
//        userSerview.findByUsernameAndPwd()
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname", token.getPrincipal().toString());
        SysUser user = userSerview.getOne(queryWrapper);
        if(user != null){
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser,user.getPwd(), ByteSource.Util.bytes(user.getSalt()),getName());
            return info;
        }

        return null;
    }
    @Autowired
    ISysUserService userSerview;
}
