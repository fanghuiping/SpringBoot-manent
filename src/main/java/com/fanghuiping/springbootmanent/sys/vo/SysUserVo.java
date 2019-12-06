package com.fanghuiping.springbootmanent.sys.vo;

import com.fanghuiping.springbootmanent.sys.domain.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVo extends SysUser {
    /**
     *
     */
    private static final long serialVersionUID=1L;

    private Integer page = 1;
    private Integer limit = 10;
}
