package com.qzsy.test.service;

import com.qzsy.test.user.model.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserSevice {
    /**
     * 注册学生
     * @param stu
     * @return
     */
    public String registerStu(@RequestBody StuStu stu);

    /**
     * 注册班级表
     * @param cour
     * @return
     */
    public String registerCour(Cour cour);

    /**
     * 注册中间表
     * @param rf
     * @return
     */
    public String registerChose(Rf rf);

    /**
     * 更新学生选课数据
     * @param stu_id
     * @param cou_id
     * @param new_id
     * @return
     */
    public String registerUpdate(Long stu_id,Long cou_id,Long new_id);

    /**
     * 查询某学生的所有选课
     * @param stu_id
     * @return
     */
    public List<StuCour> selectStu(Long stu_id);

    /**
     *查询选课的学生
     * @return
     */
    public List<StuCour> selectCour(Long cour_id);

    /**
     * mysql数据库插入用户信息
     * @param chat
     */
    public void wechatInsert(Wchat chat);

    /**
     * 将头像下载到本地
     * @param localurl
     * @param file
     */
    public void downloadLocal(String localurl,String file);

    /**
     * 从数据库获取用户信息
     * @return
     */
    public List<Wchat> getUserData();

    /**
     * 储存位置信息
     * @param local
     */
    public void wechatlocal(Local local);

    /**
     * 判断是否在有效范围内签到
     * @param lon
     * @param lati
     * @return
     */
    public boolean localRegister(double lon , double lati);
}
