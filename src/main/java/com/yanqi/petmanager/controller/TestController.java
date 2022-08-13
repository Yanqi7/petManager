package com.yanqi.petmanager.controller;


import com.yanqi.petmanager.pojo.User;
import com.yanqi.petmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "forward:index.jsp";
    }

    @RequestMapping("/test")
    public String Test(){
        System.out.println("访问了test页面……");
        return "/test.jsp";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hellologin(String username,String password){
        System.out.println("访问了get测试登录方法++++++++++"+username+"登录密码++++++"+password);
        User user = userService.login(username,password);
        if(user == null){
            return "1";
        }else if(user.getUsername()==null){
            return "2";
        }else{
            return "3:congratulation!";
        }
    }

}
