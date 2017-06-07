package com.mybatis.returnjson;

import java.io.Serializable;

/**
 * Created by user on 2017/5/22.
 */
public class JsonReturn implements Serializable {


    private int ret;

    private String message;

    private String extra;

    private Object object;

    public JsonReturn() {

    }

    public JsonReturn(int ret) {
        this.ret = ret;
    }

    public JsonReturn(int ret, String message) {
        this.ret = ret;
        this.message = message;
    }

    public JsonReturn(int ret, String message, String extra) {
        this.ret = ret;
        this.message = message;
        this.extra = extra;
    }

    public JsonReturn(int ret, String message, Object obj){
        this.ret = ret;
        this.message = message;
        this.object = obj;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
