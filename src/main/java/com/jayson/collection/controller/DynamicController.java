package com.jayson.collection.controller;

import com.jayson.collection.service.IDynamicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Resource
    private IDynamicService dynamicsService;

    @RequestMapping(value = "/getNewsDynamics", method = RequestMethod.GET)
    public Object selectListsByUserId(String userId, int currentPage, int pageSize) {
        return dynamicsService.selectListsByUserId(userId, currentPage, pageSize);
    }
}
