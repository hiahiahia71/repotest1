package com.qzsy.test.user.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;

/**
 * 中间表
 */
@Data
@TableName("rf_stu_cour")
public class Rf {
    @TableId
    private Long id;

    private Long stuId;

    private Long couId;


}
