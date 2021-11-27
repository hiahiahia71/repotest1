package com.qzsy.test.vo;

import lombok.Data;

@Data
public class Result {
    // 错误代码(200, 201)
    private int code;

    // 错误信息
    private String msg;

    // 结果数据
    private Object data;
}
