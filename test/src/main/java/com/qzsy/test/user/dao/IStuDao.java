package com.qzsy.test.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qzsy.test.user.model.Cour;
import com.qzsy.test.user.model.StuCour;
import com.qzsy.test.user.model.StuStu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStuDao extends BaseMapper<StuStu> {
    /**
     * 查询某门课的所有学生
     * @param courId
     * @return
     */
    public List<StuCour> selectClssUser(Long courId);

    /**
     * 查询某学生的所有选课
     */
    public List<StuCour> selectStuCour(Long stuId);


}
