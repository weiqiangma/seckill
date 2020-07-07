package com.example.seckill.utils;

import java.io.Serializable;

/**
 * @Date 2020/7/7 11:38
 * @Author mawkun
 */
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 3328571813730431792L;
    public static final int RESULT_CODE_SUCCESS = 200; // 成功
    public static final int RESULT_CODE_NOT_LOGGEND = 400; // 未登录
    public static final int RESULT_CODE_FAIL = 500; // 请求失败
    public static final int RESULT_CODE_UNAUTHORIZED = 505; // 没有此权限
    public static final int RESULT_CODE_NOT_SUPPORT = 600; // 版本不支持
    private int status;
    private String message;
    private T entity;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public BaseResult() {
    }

    public BaseResult(T obj) {
        setStatus(RESULT_CODE_SUCCESS);
        setEntity(obj);
    }

    public static BaseResult<String> ok(String message) {
        BaseResult<String> ret = new BaseResult<String>();
        ret.setStatus(RESULT_CODE_SUCCESS);
        ret.setMessage(message);
        ret.setEntity(null);
        return ret;
    }

    public static BaseResult<String> noBeanErro() {
        return erro("查不到该对象");
    }

    public static BaseResult<String> argError() {
        return erro("参数错误");
    }

    public static BaseResult<String> erro(String message) {
        BaseResult<String> ret = new BaseResult<String>();
        ret.setStatus(RESULT_CODE_FAIL);
        ret.setMessage(message);
        ret.setEntity(null);
        return ret;
    }

    public static BaseResult<String> notLogin() {
        BaseResult<String> ret = new BaseResult<String>();
        ret.setStatus(RESULT_CODE_NOT_LOGGEND);
        ret.setMessage("未登录");
        ret.setEntity(null);
        return ret;
    }

    public static BaseResult<String> unauth() {
        return unauth("权限不足");
    }

    public static BaseResult<String> unauth(String msg) {

        BaseResult<String> ret = new BaseResult<String>();
        ret.setStatus(RESULT_CODE_UNAUTHORIZED);
        ret.setMessage(msg);
        ret.setEntity(null);
        return ret;
    }

}

