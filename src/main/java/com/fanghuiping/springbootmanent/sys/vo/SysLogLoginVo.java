package com.fanghuiping.springbootmanent.sys.vo;

import com.fanghuiping.springbootmanent.sys.domain.SysLogLogin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "sysLogLoginVo")
public class SysLogLoginVo extends SysLogLogin {
    /**
     *
     */
    private static final long serialVersionUID=1L;

    private Integer page = 1;

    private Integer limit = 10;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
