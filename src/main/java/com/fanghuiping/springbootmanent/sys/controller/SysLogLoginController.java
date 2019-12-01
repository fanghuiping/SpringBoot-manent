package com.fanghuiping.springbootmanent.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanghuiping.springbootmanent.common.DataGridView;
import com.fanghuiping.springbootmanent.sys.domain.SysLogLogin;
import com.fanghuiping.springbootmanent.sys.service.ISysLogLoginService;
import com.fanghuiping.springbootmanent.sys.vo.SysLogLoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 方慧平
 * @since 2019-12-01
 */
@RestController
@RequestMapping("/sys/login")
public class SysLogLoginController {
    @Autowired
    ISysLogLoginService sysLogLoginService;

    /**
     * 查询所以日志
     * @param LoginVo
     * @return
     */
    @RequestMapping("loadALLLogin")
    public DataGridView loadALLLogin(SysLogLoginVo loginVo){
        IPage<SysLogLogin> iPage = new Page<>(loginVo.getPage(),loginVo.getLimit());
        QueryWrapper<SysLogLogin> tWrapper = new QueryWrapper<>();
        tWrapper.like(StringUtils.isNotBlank(loginVo.getLoginname()),"loginname",loginVo.getLoginname());
        tWrapper.like(StringUtils.isNotBlank(loginVo.getLoginip()),"loginip",loginVo.getLoginip());
        tWrapper.ge(loginVo.getStartTime()!=null,"logintime",loginVo.getStartTime());
        tWrapper.le(loginVo.getEndTime()!=null,"logintime",loginVo.getEndTime());
        sysLogLoginService.page(iPage,tWrapper);
        return new DataGridView(iPage.getTotal(),iPage.getRecords());
    }
}

