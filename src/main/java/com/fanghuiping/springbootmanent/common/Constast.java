package com.fanghuiping.springbootmanent.common;

public interface Constast {
    /**
     * 状态码
     *
     */
     Integer OK=200;
     Integer ERROR=-1;
    /**
     * 权限类型
     */
    String TYPE_MENU = "menu";
     String TYPE_PERMISSION = "permission";
    Integer AVAILABLE_TRUE = 1;
    Integer AVAILABLE_FALSE = 0;
    Integer 管理员_TRUE = 0;
    /**
     * 目录是否是打开
     */
    Integer OPEN_TRUE = 1;
    Integer OPEN_FALSE = 0;
    /**
     * 查询的一级目录
     */
    int PID_ONE = 1;
}
