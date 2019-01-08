package com.jayson.collection.dao;

import com.jayson.collection.domain.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByName(String name);

    int updateBySelective(User record);

    int update(User record);
}