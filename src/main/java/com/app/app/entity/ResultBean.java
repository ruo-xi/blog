package com.app.app.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Collection;

@Data
public class ResultBean<T> {
    public static final int SUCCESSFUL = 1;
    public static final int ERROR = 0;

    private Integer code;
    private String msg;
    private T data;
    private Collection<T> datas;

    public static ResultBean error(Integer code, String msg) {
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
        resultBean.setDatas(data);
        return resultBean;
    }

    public static <T> ResultBean<T> success(T t) {
        ResultBean resultBean = success();
        resultBean.setData(t);
        return resultBean;
    }


    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
