package com.app.app.entity;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collection;

public class ResultBean<T> {
    public static final int SUCCESSFUL = 1;
    public static final int ERROR = 0;

    private int code;
    private String msg;
    private Collection<T> data;

    public static ResultBean error(int code, String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMsg(msg);
        return resultBean;
    }

    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(SUCCESSFUL);
        resultBean.setMsg("successful");
        return resultBean;
    }

    public static <T> ResultBean<T> success(Collection<T> data) {
        ResultBean resultBean = success();
        resultBean.setData(data);
        return resultBean;
    }

    public static <T> ResultBean<T> success(T t) {
        ResultBean resultBean = success();
        ArrayList<T> data = new ArrayList<>();
        data.add(t);
        return success(data);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
