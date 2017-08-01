package com.gray.dto;

import com.github.pagehelper.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装接口返回的所有数据
 * 接口返回的参数类似
 * {code: 200, msg: "查询成功", data: {name: "e_joy"}}
 * Created by leigang on 2017/3/13.
 */
public class Resp {

    public static Resp PARAM_WRONG = new Resp(State.REQUEST_WRONG); //快捷获取参数错误，在没有data值的时候才能使用

    //返回状态码
    private int code;
    //返回信息
    private String msg;
    //数据对象
    private Object data;

    //默认构造函数
    public Resp() {
    }

    //使用枚举初始化
    private Resp(State stateEnum) {
        this.code = stateEnum.getState();
        this.msg = stateEnum.getStateInfo();
    }

    //包含所有参数的构造函数
    public Resp(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功的时候构造方法（几个获取Resp的静态方法方法体相同，仅仅在语义上有所区分）
     *
     * @param stateEnum 枚举
     * @return Resp对象
     */
    public static Resp success(State stateEnum) {
        return new Resp(stateEnum);
    }

    /**
     * 重载成功的构造方法
     *
     * @return Resp对象
     */
    public static Resp success() {
        return new Resp(State.SUCCESS);
    }

    /**
     * 发生错误的时候构造方法
     *
     * @param stateEnum 枚举
     * @return Resp对象
     */
    public static Resp error(State stateEnum) {
        return new Resp(stateEnum);
    }

    //快捷获取500错误
    public static Resp error() {

        return new Resp(State.ERROR);
    }

    /**
     * 非成功时，也并非报错的时候构造方法
     *
     * @param stateEnum 枚举
     * @return Resp对象
     */
    public static Resp info(State stateEnum) {
        return new Resp(stateEnum);
    }

    /**
     * 向返回值中添加内容
     *
     * @param key   返回数据的key
     * @param value 返回数据的value
     * @return 返回Resp对象，可以链式添加
     */
    public Resp put(String key, Object value) {
        if (StringUtil.isEmpty(key)) {
            //传入的key 不存在的话直接返回
            return this;
        }
        if (data == null) {
            data = new HashMap<String, Object>();
            ((Map<String, Object>) data).put(key, value);
        } else if (data instanceof Map) {
            ((Map<String, Object>) data).put(key, value);
        }
        return this;
    }

    public Resp setData(Object data) {
        this.data = data;
        return this;
    }

    /* Getter and setter methods */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Resp setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
