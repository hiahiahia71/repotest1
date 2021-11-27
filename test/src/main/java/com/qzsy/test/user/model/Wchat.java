package com.qzsy.test.user.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.var;

import java.time.LocalDateTime;

/**
 * 存储微信用户信息
 */
@Data
@TableName("user_user")
public class Wchat {
    @TableId
    private Long id;

    private String nickName;

    private String city;

    private String province;

    private String country;

    private String language;

    private String gender;

    private String avatarUrl;

    private String latitude;

    private String longitude;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime create_time;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;
}
