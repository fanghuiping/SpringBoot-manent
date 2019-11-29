package com.fanghuiping.springbootmanent.common;

import com.fanghuiping.springbootmanent.sys.domain.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data //生成git/set方法
@AllArgsConstructor // 有参构造方法
@NoArgsConstructor //无参构造方法
public class ActiverUser {
    private SysUser user;
    private List<String> roles;
    private List<String> permissions;
}
