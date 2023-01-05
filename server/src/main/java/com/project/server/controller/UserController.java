package com.project.server.controller;


import com.project.server.dto.UserModel;
import com.project.server.entity.User;
import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService<UserModel> userService;
//    @GetMapping("/api/users")
//    public List<UserModel> listUser(){
//        List<UserModel> users = userService.findAll();
////        ModelAndView modelAndView = new ModelAndView("/users/list");
////        modelAndView.addObject("users",users);
//        return users;
//    }
    @GetMapping("/api/users/{token}")
    public ResponseEntity<UserModel> getUserByToken(@PathVariable("token") String token){
        UserModel user = userService.findbyToken(token);
        if (user == null){
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        else{
        return ResponseEntity.ok(user);
        }

    }
    @PostMapping("/api/users/create")
    public ResponseEntity<UserModel> CreateUser(@RequestBody UserModel userModel){
        UserModel user = userService.addNewUser(userModel);

        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @GetMapping("/api/users")
    public ResponseEntity<UserModel> getUserByPassword(@RequestParam String username,@RequestParam String password){
        UserModel user = userService.findbyPassword(username,password);
        if (user == null){
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(user);
        }
    }
}
