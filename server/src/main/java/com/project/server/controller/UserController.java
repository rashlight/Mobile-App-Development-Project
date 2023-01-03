package com.project.server.controller;

import com.project.server.model.*;
import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ModelAndView listUser(){
        List<UserModel> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/users/list");
        modelAndView.addObject("users",users);
        return modelAndView;
    }
    @GetMapping("/users/{id}")
    public ModelAndView getuserbyid(@PathVariable UUID id){
        UserModel user = userService.findbyId(id);
        if(user != null){
            ModelAndView modelAndView = new ModelAndView("/users/id");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
