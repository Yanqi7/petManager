package com.yanqi.petmanager.controller;

import com.yanqi.petmanager.pojo.Pet;
import com.yanqi.petmanager.service.PetService;
import com.yanqi.petmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @RequestMapping("/list")
    public String showList(HttpServletRequest request, HttpSession session) throws IOException {
        // 编码
        request.setCharacterEncoding("utf-8");
        String petBreed = request.getParameter("petBreed");
        String username = (String) session.getAttribute("username");
        if(username==null){
            return "/login";
        }
        if(petBreed == null){
            petBreed = "0";
        }
        List<Pet> list = petService.findByPetBreed(Integer.parseInt(petBreed));
        request.setAttribute("list",list);
        request.setAttribute("username",username);
        return "list";
    }

    @RequestMapping("/add")
    public String addPetPage(){
        return "add";
    }

    @RequestMapping("/doadd")
    @ResponseBody
    public String doAdd(){

        return "3";
    }

}
