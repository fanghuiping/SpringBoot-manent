package com.fanghuiping.springbootmanent.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanghuiping.springbootmanent.common.*;
import com.fanghuiping.springbootmanent.sys.domain.SysPermission;
import com.fanghuiping.springbootmanent.sys.domain.SysUser;
import com.fanghuiping.springbootmanent.sys.service.ISysPermissionService;
import com.fanghuiping.springbootmanent.sys.vo.SysPermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 方慧平
 * @since 2019-11-28
 */
@RestController
@Api(value = "目录")
public class SysPermissionController {
    @Autowired
    ISysPermissionService permissionService;

    @ApiOperation(value = "获取目录数据")
    @GetMapping("navs")
    public DataGridView navs(SysPermissionVo permissionVo) {
        QueryWrapper<SysPermission> tWrapper = new QueryWrapper<>();
        tWrapper.eq("type", Constast.TYPE_MENU);
        tWrapper.eq("available", Constast.AVAILABLE_TRUE);
        SysUser sysUser = (SysUser) WebUtils.getSession().getAttribute("user");
        List<SysPermission> permissionList = null;
        if (sysUser.getType() == Constast.管理员_TRUE) {
            permissionList = permissionService.list(tWrapper);
        } else {
            /**
             * 不是管理员
             */
        }
        List<TodeNode> todeNodeList = new ArrayList<>();
        for (SysPermission permission : permissionList) {
            Integer id = permission.getId();
            Integer pid = permission.getPid();
            String title = permission.getTitle();
            String icon = permission.getIcon();
            String href = permission.getHref();
            Boolean spread = permission.getOpen()==Constast.OPEN_TRUE?true:false;
            todeNodeList.add(new TodeNode(id,pid,title,icon,href,spread));
        }
        return new DataGridView(Tooles.navsSort(todeNodeList,Constast.PID_ONE));
    }


}

