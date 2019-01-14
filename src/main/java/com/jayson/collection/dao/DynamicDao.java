package com.jayson.collection.dao;

import com.jayson.collection.domain.Dynamic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DynamicDao {
    /**
     * 根据用户名查找相关的动态列表
     *
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Select("select * from t_dynamic where user_Id = #{userId} limit #{currentPage},#{pageSize}")
    //查询多对一的用户信息(必须要有selectById方法)
    @Results({@Result(property = "user", column = "user_id",
            one = @One(select = "com.jayson.collection.dao.UserDao.selectById"))})
    List<Dynamic> selectListsByUserId(@Param("userId") String userId,
                                      @Param("currentPage") int currentPage,
                                      @Param("pageSize") int pageSize);
}