package com.qzsy.test.user.controller;

import com.qzsy.test.service.UserSevice;
import com.qzsy.test.user.model.Cour;
import com.qzsy.test.user.model.Rf;
import com.qzsy.test.user.model.StuCour;
import com.qzsy.test.user.model.StuStu;
import com.qzsy.test.vo.Result;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Data
public class UserController {
    @Autowired
    private UserSevice userservice;

    /**
     * 向学生表插入信息
     * @param stu
     * @return
     */
    @PostMapping("/registerStu")
    @ResponseBody
    public Result registerStu(@RequestBody StuStu stu){
        Result rst = new Result();
        userservice.registerStu(stu);
        rst.setCode(201);
        rst.setData(stu);
        rst.setMsg("成功");
        return rst;
    }

    /**
     * 向班级表插入信息
     * @param cour
     * @return
     */
    @PostMapping("/registerCour")
    @ResponseBody
    public Result registerCour(@RequestBody Cour cour){
        Result rst = new Result();
        userservice.registerCour(cour);
        rst.setCode(201);
        rst.setData(cour);
        rst.setMsg("成功");
        return rst;
    }

    /**
     * 学生选课操作
     * @param rf
     * @return
     */
    @PostMapping("/registerCourRf")
    @ResponseBody
    public Result registerChose(@RequestBody Rf rf){
        Result rst = new Result();
        userservice.registerChose(rf);
        rst.setCode(201);
        rst.setData(rf);
        rst.setMsg("成功");
        return rst;
    }

    /**
     * 更新学生选课信息
     * @param stu_id
     * @param cou_id
     * @param new_id
     * @return
     */
    @PostMapping("/registerupdate")
    public Result registerUpdate(Long stu_id, Long cou_id, Long new_id){
        Result rst = new Result();
        userservice.registerUpdate(stu_id,cou_id,new_id);
        rst.setCode(201);
        rst.setData(stu_id);
        rst.setMsg("成功");
        return rst;
    }

    /**
     * 查询某学生的所有选课
     * @param stu_id
     * @return
     */
    @PostMapping("/registerselectstu")
    public List<StuCour> selectStu(Long stu_id){
        System.out.println(stu_id);
        return userservice.selectStu(stu_id);
    }

    /**
     * 查看某课程的所有学生
     * @param cour_id
     * @return
     */
    @PostMapping("/registerselectcour")
    public List<StuCour> selectSelectCour(Long cour_id){
        System.out.println(cour_id);
        return userservice.selectCour(cour_id);
    }

}
