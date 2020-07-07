package com.example.seckill.controller;

import com.example.seckill.entity.SkUser;
import com.example.seckill.model.UserSession;
import com.example.seckill.service.SkUserService;
import com.example.seckill.spring.annotation.LoginUser;
import com.example.seckill.utils.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date 2020/7/7 11:16
 * @Author mawkun
 */
@RestController
public class SkLoginController {

    @Resource
    SkUserService skUserService;

    @RequestMapping("login")
    public BaseResult login(SkUser user) {
        return skUserService.login(user);

    }

    @RequestMapping("test")
    public String login(@LoginUser UserSession session) {
        String token = session.getTokne();
        String name = session.getUserName();
        String msg = "hello" + name;
        return msg;

    }
}
