package com.qzsy.test.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qzsy.test.user.model.Wchat;

import java.util.List;

public interface IUserDao extends BaseMapper<Wchat> {
    /**
     * 获得mysql user_user表信息
     * @return
     */
    public List<Wchat> GetUserInfo();
}
