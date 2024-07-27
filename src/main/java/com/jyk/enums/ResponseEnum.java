package com.jyk.enums;

/**
 * @author : Jing Yuankui
 * @description : 返回枚举类型
 * @date : Created in 2024/7/28 0:12
 */
public enum ResponseEnum {
    /**
     * 数据操作错误定义
     */
    SUCCESS("S000","操作成功!"),
    ERROR("E000","操作失败!"),
    SIGNATURE_NOT_MATCH("E001","请求的数字签名不匹配!"),
    BODY_NOT_MATCH("E002","请求的数据格式不符!"),
    INTERNAL_SERVER_ERROR("E003", "服务器内部错误!"),
    PARAM_ERROR("E004", "参数错误!"),
    ;

    /**
     * 错误码
     */
    private String resultCode;
    /**
     * 错误描述
     */
    private String resultMsg;

    ResponseEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
