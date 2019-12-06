package com.fanghuiping.springbootmanent.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanghuiping.springbootmanent.common.DataGridView;
import com.fanghuiping.springbootmanent.common.ResultObj;
import com.fanghuiping.springbootmanent.sys.domain.SysLogLogin;
import com.fanghuiping.springbootmanent.sys.service.ISysLogLoginService;
import com.fanghuiping.springbootmanent.sys.vo.SysLogLoginVo;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 方慧平
 * @since 2019-12-01
 */
@RestController
@Api(value = "日志控制器")
@RequestMapping("/sys/login")
public class SysLogLoginController {
    @Autowired
    ISysLogLoginService sysLogLoginService;

    /**
     * 查询所有日志
     *
     * @param loginVo
     * @return
     */
    @GetMapping("loadALLLogin")
    @ApiOperation(value = "查询日志，默认显示全部日志",httpMethod = "GET")
    public DataGridView loadALLLogin(SysLogLoginVo loginVo) {
        IPage<SysLogLogin> iPage = new Page<>(loginVo.getPage(), loginVo.getLimit());
        QueryWrapper<SysLogLogin> tWrapper = new QueryWrapper<>();
        tWrapper.like(StringUtils.isNotBlank(loginVo.getLoginname()), "loginname", loginVo.getLoginname());
        tWrapper.like(StringUtils.isNotBlank(loginVo.getLoginip()), "loginip", loginVo.getLoginip());
        tWrapper.ge(loginVo.getStartTime() != null, "logintime", loginVo.getStartTime());
        tWrapper.le(loginVo.getEndTime() != null, "logintime", loginVo.getEndTime());
        tWrapper.orderByDesc("logintime");
        sysLogLoginService.page(iPage, tWrapper);
        return new DataGridView(iPage.getTotal(), iPage.getRecords());
    }

    @PostMapping("deleteLoginfo")
    @ApiOperation(value = "删除日志")
    public ResultObj deleteLoginfo(Integer id) {
        try {
            if (id == null)
                throw new Exception();
            QueryWrapper<SysLogLogin> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);

            sysLogLoginService.remove(queryWrapper);
            return ResultObj.LOGLOGIN_DEL_SUCCESS;
        } catch (Exception e) {
            return ResultObj.LOGLOGIN_DEL_ERROR;
        }
    }

    @PostMapping("updataLoginfo")
    @ApiOperation(value = "修改日志")
    public ResultObj updataLoginfo(SysLogLoginVo sysLogLoginVo){
        try {
            sysLogLoginService.updateById(sysLogLoginVo);
            return  ResultObj.LOGLOGIN_UPD_SUCCESS;
        }catch (Exception e) {
            return ResultObj.LOGLOGIN_UPD_ERROR;
        }
    }

}

