package com.JavaWebMall.Bean;

import java.util.HashMap;
import java.util.Map;

public class Message {
    //状态码，100表示处理成功，200表示处理失败
    private int code;
    //提示信息
    private String message;
    //用户要返回给浏览器的信息
    private Map<String, Object> extend = new HashMap<>();

    public static Message success(){
        Message result = new Message();
        result.setCode(100);
        result.setMessage("success!");
        return result;
    }

    public static Message failed(){
        Message result = new Message();
        result.setCode(200);
        result.setMessage("failed!");
        return result;
    }

    public Message add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
