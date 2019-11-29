package com.fanghuiping.springbootmanent.common;


public class ResultObj {

    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Constast.OK,"登录成功");
    public static final ResultObj LOGIN_ERROR_PASS=new ResultObj(Constast.ERROR,"登录失败,用户名密码失败");
    public static final ResultObj LOGIN_ERROR_CODE=new ResultObj(Constast.ERROR,"登录失败，验证码不正确");

    private Integer code;
    private String msg;

    public ResultObj() {
    }

    public ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
