package com.jayson.collection.controller;

import com.jayson.collection.entity.TestBean;
import com.jayson.collection.entity.common.WrapResListEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object getTestData(int page, int limit) {
        System.out.println(page + "------" + limit);
        List<Object> totalList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            TestBean testBean =
                    new TestBean(i + 1, "Spring实战", "java实战书籍", "Lojs", "2018-1-" + i);
            totalList.add(testBean);
        }
        List<Object> bookList = new ArrayList<>();
        for (int i = (page - 1) * limit; i < (page - 1) * limit + limit; i++) {
            if (i < totalList.size()) {
                bookList.add(totalList.get(i));
            }
        }
        WrapResListEntity wrapResEntity = new WrapResListEntity();
        wrapResEntity.setCode(0);
        wrapResEntity.setMsg("书籍信息");
        wrapResEntity.setCount(totalList.size());
        wrapResEntity.setList(bookList);
        return wrapResEntity;
    }
}
