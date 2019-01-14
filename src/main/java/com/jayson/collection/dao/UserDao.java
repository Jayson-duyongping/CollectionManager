package com.jayson.collection.dao;

import com.jayson.collection.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户dao
 */
public interface UserDao {
    /**
     * 保存
     *
     * @param record
     * @return
     */
    @Insert({"insert into t_user (id, username, password, headicon," +
            " phonenumber, sina, qq, wx, nickname, sex, birthday," +
            " sketch, address, description, hobby, skill)" +
            " values (#{id}, #{username}, #{password}, #{headicon}," +
            " #{phonenumber},#{sina},#{qq}," +
            " #{wx},#{nickname},#{sex},#{birthday},#{sketch}," +
            " #{address},#{description}, #{hobby}, #{skill})"})
    int insert(User record);

    /**
     * 根据用户名查找
     *
     * @param name
     * @return
     */
    @Select("select * from t_user where username = #{name}")
    User selectByName(@Param("name") String name);

    /**
     * 根据用户id查找
     *
     * @param id
     * @return
     */
    @Select("select * from t_user where id = #{id}")
    User selectById(@Param("id") String id);
}