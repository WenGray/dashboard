package com.gray.dto;

/**
 * 使用枚举表述常量数据字典
 * Created by leigang on 16/6/22.
 */
public enum State {
    SUCCESS(200, "请求成功"),
    REQUEST_WRONG(400, "参数错误"),
    RE_SEND(403, "重复发送"),
    REQUEST_ABNORMAL(406, "请求异常"),
    ERROR(500, "Server Error")
    ;

    private int state;

    private String stateInfo;

    State(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static State stateOf(int index) {
        for (State state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
