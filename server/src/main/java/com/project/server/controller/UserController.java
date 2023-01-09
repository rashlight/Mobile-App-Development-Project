package com.project.server.controller;


import com.project.server.dto.UserModel;
import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public ResponseEntity voidCreateUser(@RequestBody UserModel userModel){
        if (userModel == null){
            return new ResponseEntity<String>("Bad request",HttpStatus.BAD_REQUEST);
        }
        try {
            userService.addNewUser(userModel);
            return new ResponseEntity<String>("User Created",HttpStatus.CREATED);
        }catch(OptimisticLockingFailureException Fe)
            {
            return new ResponseEntity<String>("Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
