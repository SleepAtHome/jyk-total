package com.jyk.vo;

import com.jyk.enums.ResponseEnum;

/**
 * @author : Jing Yuankui
 * @description : 统一返回类
 * @date : Created in 2024/7/28 0:09
 */
public class ResponseVo<T> {
    /**
     * 响应编码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 不允许调用默认构造方法
     */
    private ResponseVo() {
    }

    /**
     * 成功返回
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseVo<T> success(T data) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setCode(ResponseEnum.SUCCESS.getResultCode());
        responseVo.setMsg(ResponseEnum.SUCCESS.getResultMsg());
        responseVo.setData(data);
        return responseVo;
    }

    /**
     * 失败返回
     * @return
     */
    public static <T> ResponseVo<T> error(T data) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setCode(ResponseEnum.ERROR.getResultCode());
        responseVo.setMsg(ResponseEnum.ERROR.getResultMsg());
        responseVo.setData(data);
        return responseVo;
    }

    /**
     * 自定义失败返回
     * @param responseEnum
     * @return
     * @param <T>
     */
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setCode(responseEnum.getResultCode());
        responseVo.setMsg(responseEnum.getResultMsg());
        responseVo.setData(null);
        return responseVo;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
