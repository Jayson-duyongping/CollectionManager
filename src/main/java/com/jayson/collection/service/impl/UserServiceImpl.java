package com.jayson.collection.service.impl;

import com.jayson.collection.constant.CodeStatus;
import com.jayson.collection.dao.UserDao;
import com.jayson.collection.domain.User;
import com.jayson.collection.domain.common.WrapTipEntity;
import com.jayson.collection.service.IUserService;
import com.jayson.collection.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * anchor: jayson
 * date: 2018/12/26
 * description: 用户逻辑实现类
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    /**
     * 登录操作
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public WrapTipEntity login(String username, String password) {
        WrapTipEntity entity = new WrapTipEntity();
        //获取数据库的用户
        User user = userDao.selectByName(username);
        if (null != user) {
            //说明数据库有此数据
            if (username.equals(user.getUsername())
                    && password.equals(MD5Util.convertMD5(user.getPassword()))) {
                //返回登录成功
                entity.setCode(CodeStatus.SUCCESS);
                entity.setMsg("登录成功");
            } else {
                //返回登录失败
                entity.setCode(CodeStatus.FAILURE);
                entity.setMsg("登录失败");
            }
        } else {
            //说明数据库没有此数据
            entity.setCode(CodeStatus.TIP);
            entity.setMsg("没有此账号，请注册");
        }
        return entity;
    }

    /**
     * 注册操作
     *
     * @param user
     * @return
     */
    @Override
    public WrapTipEntity register(User user) {
        WrapTipEntity entity = new WrapTipEntity();
        //查询是否有存在的用户
        User exsitUser = userDao.selectByName(user.getUsername());
        if (exsitUser != null) {
            //存在用户
            entity.setCode(CodeStatus.TIP);
            entity.setMsg("用户名已被使用");
            return entity;
        }
        //密码加密
        user.setPassword(MD5Util.convertMD5(user.getPassword()));
        //保存到数据库
        int res = userDao.insert(user);
        if (res == 1) {
            //保存成功
            entity.setCode(CodeStatus.SUCCESS);
            entity.setMsg("注册成功");
        } else {
            //保存失败
            entity.setCode(CodeStatus.FAILURE);
            entity.setMsg("注册失败");
        }
        return entity;
    }
}
