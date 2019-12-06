package com.fanghuiping.springbootmanent.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 方慧平
 * @since 2019-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "用户")
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id",name = "id",example = "1")
    private Integer id;

    @ApiModelProperty(value = "name",name = "用户名")
    private String name;
    @ApiModelProperty(value = "loginname",name = "登陆名")
    private String loginname;
    @ApiModelProperty(value = "address",name = "地址")
    private String address;
    @ApiModelProperty(value = "sex",name = "性别",example = "1")
    private Integer sex;
    @ApiModelProperty(value = "remark",name = "备注")
    private String remark;
    @ApiModelProperty(value = "pwd",name = "密码")
    private String pwd;
    @ApiModelProperty(value = "deptid",name = "所属部门编号",example = "1")
    private Integer deptid;
    @ApiModelProperty(value = "hiredate",name = "入职时间")
    private Date hiredate;
    @ApiModelProperty(value = "mgr",name = "上级领导id[工作流要使用]",example = "1")
    private Integer mgr;
    @ApiModelProperty(value = "available",name = "状态【0不可用1可用】",example = "1")
    private Integer available;
    @ApiModelProperty(value = "ordernum",name = "排序码【为了调事显示顺序】",example = "1")
    private Integer ordernum;

    /**
     * 用户类型[0超级管理员1，管理员，2普通用户]
     */
    private Integer type;

    /**
     * 头像地址
     */
    private String imgpath;

    private String salt;


}
