package com.fanghuiping.springbootmanent.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 方慧平
 * @since 2019-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "日志实体类")
public class SysLogLogin implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id",name = "id",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(name = "loginname",value = "日志名字",example = "ddsf")
    private String loginname;

    @ApiModelProperty(name = "loginip",value = "日志ip",example = "121.0.0.1")
    private String loginip;

    @ApiModelProperty(name = "logintime",value = "日志时间",example = "2019/12/4 13:12:01")
    private LocalDateTime logintime;


}
