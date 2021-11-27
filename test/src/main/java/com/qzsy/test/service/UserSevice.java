package com.qzsy.test.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qzsy.test.user.dao.*;
import com.qzsy.test.user.model.*;
import com.qzsy.test.util.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class UserSevice implements IUserSevice{

    //教室经度
    private static final double LONGITUDE = 119.29659;

    //教室纬度
    private static final double LATITUDE = 26.09982;

    @Autowired
    private IRf rfDao;

    @Autowired
    private IStuDao userDao;

    @Autowired
    private ICourDao courDao;

    @Autowired
    private IUserDao useDao;

    @Autowired
    private ILocalDao localDao;
    /**
     * 注册学生表
     * @param stu
     * @return
     */
    @Override
    public String registerStu(StuStu stu) {
        userDao.insert(stu);
        return null;
    }

    /**
     * 注册班级表
     * @param cour
     * @return
     */
    @Override
    public String registerCour(Cour cour) {
        courDao.insert(cour);
        return null;
    }

    /**
     * 注册中间表
     * @param rf
     * @return
     */
    @Override
    public String registerChose(Rf rf) {
        rfDao.insert(rf);
        return null;
    }

    /**
     * 更新学生选课信息
     * @param stu_id
     * @param cou_id
     * @param new_id
     * @return
     */
    @Override
    public String registerUpdate(Long stu_id,Long cou_id,Long new_id) {
        QueryWrapper<Rf> qw = new QueryWrapper<Rf>();
        qw.lambda().eq(Rf::getStuId,stu_id);
        Rf rf = rfDao.selectOne(qw);
        rf.setCouId(new_id);
        rfDao.updateById(rf);
        return null;
    }

    /**
     * 查询某学生的所有选课
     * @param stu_id
     * @return
     */
    @Override
    public List<StuCour> selectStu(Long stu_id) {
        System.out.println(stu_id);
        List<StuCour> sc = userDao.selectStuCour(stu_id);
        System.out.println(sc);
        return sc;
    }

    /**
     * 查询某门课的所有学生
     * @param cour_id
     * @return
     */
    @Override
    public List<StuCour> selectCour(Long cour_id) {
        List<StuCour> sc = userDao.selectClssUser(cour_id);
        System.out.println(sc);
        return sc;
    }

    /**
     * mysql数据库插入用户信息
     * @param chat
     */
    @Override
    public void wechatInsert(Wchat chat) {
        useDao.insert(chat);
        System.out.println(chat);
    }

    /**
     * 将头像下载到本地
     * @param localurl
     * @param file
     */
    @Override
    public void downloadLocal(String localurl, String file) {
        try{
            URL url = new URL(localurl);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            FileOutputStream fis = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int count=0;
            while((count = bis.read(buffer,0,1024)) != -1)
            {
                fis.write(buffer, 0, count);
            }
            fis.close();
            bis.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 从数据库获取用户信息
     * @return
     */
    @Override
    public List<Wchat> getUserData() {
        List<Wchat> ud = useDao.GetUserInfo();
        System.out.println(ud);
        return ud;
    }

    @Override
    public void wechatlocal(Local local) {
        localDao.insert(local);
    }

    @Override
    public boolean localRegister(double lon, double lati) {
        System.out.println(DistanceUtil.LantitudeLongitudeDist(LONGITUDE,LATITUDE,lon,lati));
        return false;
    }

}
