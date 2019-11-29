package com.fanghuiping.springbootmanent.sys.controller;


import com.fanghuiping.springbootmanent.common.ActiverUser;
import com.fanghuiping.springbootmanent.common.ResultObj;
import com.fanghuiping.springbootmanent.common.WebUtils;
import com.fanghuiping.springbootmanent.sys.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 方慧平
 * @since 2019-11-23
 */
@RestController
public class SysUserController {

    @PostMapping("/login")
    public ResultObj list(String username, String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username,pwd);
        try {
            subject.login(token);
            ActiverUser activerUser = (ActiverUser)subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activerUser.getUser());
            return ResultObj.LOGIN_SUCCESS;
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }
    @Autowired
    ISysUserService userSerview;

}

