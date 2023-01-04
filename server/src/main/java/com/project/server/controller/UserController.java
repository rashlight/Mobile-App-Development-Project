package com.project.server.controller;


import com.project.server.dto.UserModel;
import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService userService;
//    @GetMapping("/api/users")
//    public List<UserModel> listUser(){
//        List<UserModel> users = userService.findAll();
////        ModelAndView modelAndView = new ModelAndView("/users/list");
////        modelAndView.addObject("users",users);
//        return users;
//    }
//    @GetMapping("/users/{id}")
//    public ModelAndView getuserbyid(@PathVariable UUID id){
//        UserModel user = userService.findbyId(id);
//        if(user != null){
//            ModelAndView modelAndView = new ModelAndView("/users/id");
//            modelAndView.addObject("user",user);
//            return modelAndView;
//        }
//        else{
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//
//    }
    @PostMapping("/api/users")
    public ModelAndView CreateUser(@RequestBody UserModel userModel){
        userService.save(userModel);
        ModelAndView modelAndView = new ModelAndView("/users/create");
        modelAndView.addObject("users",userModel);
        modelAndView.addObject("message","successfully");
        return modelAndView;
    }
}
