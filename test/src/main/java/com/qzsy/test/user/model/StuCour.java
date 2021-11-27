package com.qzsy.test.user.model;

import lombok.Data;

/**
 * 存储学生表和课程表信息
 */
@Data
public class StuCour {
    private String stuName;

    private String stuNum;

    private String courName;

    private String courHour;

    private String sex;
}
