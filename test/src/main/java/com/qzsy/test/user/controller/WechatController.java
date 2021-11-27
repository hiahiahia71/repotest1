package com.qzsy.test.user.controller;

import com.alibaba.druid.sql.visitor.functions.Hex;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.qzsy.test.service.UserSevice;
import com.qzsy.test.user.model.Local;
import com.qzsy.test.user.model.StuStu;
import com.qzsy.test.user.model.Wchat;
import com.qzsy.test.vo.Result;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * 从微信获取信息
 */
@RestController
@RequestMapping("/user")
@Data
public class WechatController {

    @Autowired
    private UserSevice userSevice;
    /**
     * 从微信小程序获取用户信息并插入mysql数据库
     * @param wchat
     * @return
     */
    @PostMapping("/wechat")
    @ResponseBody
    public Result reqWeChat(@RequestBody Wchat wchat){
//        String str = new String(wchat.getNickName().getBytes(),"utf-8");
//        wchat.setNickName(URLDecoder.decode(URLEncoder.encode(wchat.getNickName(), "utf-8"), "UTF-8"));
        String file = "C:/Users/16471/Desktop/pic/" + wchat.getNickName() + ".jpg";
        userSevice.downloadLocal(wchat.getAvatarUrl(),file);
        userSevice.wechatInsert(wchat);
        Result rst = new Result();
        rst.setCode(201);
        rst.setData(wchat);
        rst.setMsg("成功");
        System.out.println(wchat);
        return rst;
    }

    @PostMapping("/getinfo")
    public List<Wchat> getInfoWechat(){
        List<Wchat> ud = userSevice.getUserData();
        Result rst = new Result();
        rst.setCode(201);
        rst.setData(ud);
        rst.setMsg("成功");
        System.out.println(rst);
        return ud;
    }

    @PostMapping("/local")
    public Result weChatLocal(@RequestBody Local local){
        userSevice.wechatlocal(local);
        userSevice.localRegister(local.getLongitude(),local.getLatitude());
        Result rst = new Result();
        rst.setCode(201);
        rst.setData(local);
        rst.setMsg("成功");
        System.out.println(rst);
        return rst;
    }
//    /**
//     * mysql插入用户数据
//     * @param chat
//     * @return
//     */
//    public Result insertWechat(Wchat chat){
//        Result rst = new Result();
//        userSevice.wechatInsert(chat);
//        rst.setCode(201);
//        rst.setData(chat);
//        rst.setMsg("成功");
//        return rst;
//    }

}
