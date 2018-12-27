package com.jayson.collection.service;

import com.jayson.collection.domain.User;
import com.jayson.collection.domain.common.WrapTipEntity;

/**
 * anchor: jayson
 * date: 2018/12/26
 * description:
 */
public interface IUserService {
    /**
     * 用户登录（查找）
     *
     * @param name
     * @return
     */
    WrapTipEntity login(String name, String password);

    /**
     * 用户注册（保存）
     *
     * @param user
     * @return
     */
    WrapTipEntity register(User user);
}
