package com.jayson.collection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//扫描dao层接口
@MapperScan("com.jayson.collection.dao")
public class CollectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectionApplication.class, args);
    }
}
