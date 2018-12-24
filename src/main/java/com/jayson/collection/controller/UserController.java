package com.jayson.collection.controller;

import com.jayson.collection.entity.TestBean;
import com.jayson.collection.entity.common.WrapResObjEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object getTestData(String username, String password) {
        System.out.println(username + "------" + password);
        WrapResObjEntity wrapResEntity = new WrapResObjEntity();
        wrapResEntity.setCode(0);
        wrapResEntity.setMsg("书籍信息");
        wrapResEntity.setData(new TestBean(1, "zhangsan", "zhangsan", "zhangsan", "asdad"));
        return wrapResEntity;
    }
}
