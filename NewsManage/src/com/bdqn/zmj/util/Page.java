package com.bdqn.zmj.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ChaW
 * Date: 2019/3/26
 * Time: 15:36
 * Description: No Description
 */
public class Page<T> {

    private int code = 0;
    private int count;
    private String msg;
    private List<T> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
