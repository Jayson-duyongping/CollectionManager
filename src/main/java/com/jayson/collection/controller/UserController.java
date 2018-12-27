package com.jayson.collection.controller;

import com.jayson.collection.domain.User;
import com.jayson.collection.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(String username, String password) {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(User user) {
        return userService.register(user);
    }
}
