package com.fanghuiping.springbootmanent.common;

/**
 * 接口返回状态
 */
public class ResultObj {

    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Constast.OK,"登录成功");
    public static final ResultObj LOGIN_ERROR_PASS=new ResultObj(Constast.ERROR,"登录失败,用户名密码失败");
    public static final ResultObj LOGIN_ERROR_CODE=new ResultObj(Constast.ERROR,"登录失败，验证码不正确");
    public static final ResultObj LOGLOGIN_DEL_SUCCESS = new ResultObj(Constast.OK,"删除成功");
    public static final ResultObj LOGLOGIN_DEL_ERROR = new ResultObj(Constast.ERROR,"删除失败");
    public static final ResultObj LOGLOGIN_UPD_SUCCESS = new ResultObj(Constast.OK,"修改成功");
    public static final ResultObj LOGLOGIN_UPD_ERROR = new ResultObj(Constast.ERROR,"修改失败");
    public static final ResultObj FIND_SUCCESS = new ResultObj(Constast.OK,"添加成功");
    public static final ResultObj FIND_ERROR = new ResultObj(Constast.ERROR,"添加失败");

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
