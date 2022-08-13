package com.yanqi.petmanager.controller;

import com.yanqi.petmanager.pojo.User;
import com.yanqi.petmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    @RequestMapping("/login")
    public String showlogin(){
        System.out.println("访问了login方法……++++++++++++++++++++");
        return "login";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    @ResponseBody
    public String postlogin(@RequestParam("username")String username,@RequestParam("password") String userpassword, HttpSession session){
        System.out.println("访问了post登录方法++++++++++"+username+"登录密码++++++"+userpassword);
        User user = userService.login(username,userpassword);
        if(user == null){
            return "1";
        }else if(user.getUsername()==null){
            return "2";
        }else{
            session.setAttribute("username",username);
            return "3";
        }
    }

}
