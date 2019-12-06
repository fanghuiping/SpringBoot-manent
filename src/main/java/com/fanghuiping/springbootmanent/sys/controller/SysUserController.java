package com.fanghuiping.springbootmanent.sys.controller;


import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanghuiping.springbootmanent.common.DataGridView;
import com.fanghuiping.springbootmanent.common.ResultObj;
import com.fanghuiping.springbootmanent.sys.domain.SysUser;
import com.fanghuiping.springbootmanent.sys.service.ISysUserService;
import com.fanghuiping.springbootmanent.sys.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 方慧平
 * @since 2019-11-23
 */
@RestController
@Api(value = "用户管理")
@RequestMapping("userManagement")
public class SysUserController {
    @Autowired
    ISysUserService userSerview;

    @PostMapping("findAllUser")
    @ApiOperation(value = "查看所有用户")
    public DataGridView userManagement() {
        SysUserVo sysUserVo = new SysUserVo();
        IPage<SysUser> iPage = new Page<>(sysUserVo.getPage(), sysUserVo.getLimit());
        userSerview.page(iPage);
        return new DataGridView(iPage.getTotal(), iPage.getRecords());
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(Integer id) {
        try {
            userSerview.removeById(id);
            return ResultObj.LOGLOGIN_DEL_SUCCESS;
        } catch (Exception e) {
            return ResultObj.LOGLOGIN_DEL_ERROR;
        }
    }

    @ApiOperation(value = "添加客户")
    @PostMapping("saveUser")
    public ResultObj saveUser(SysUserVo sysUserVo) {
        try {
            userSerview.save(sysUserVo);
            return ResultObj.FIND_SUCCESS;
        } catch (Exception e) {
            e.getMessage();
            return ResultObj.FIND_ERROR;
        }
    }
    @ApiOperation(value = "修改客户")
    @PostMapping("updUser")
    public ResultObj updUser(SysUserVo sysUserVo){
        try {
            userSerview.updateById(sysUserVo);
            return ResultObj.LOGLOGIN_UPD_SUCCESS;
        }catch (Exception e){
            return ResultObj.LOGLOGIN_UPD_ERROR;
        }
    }
}

