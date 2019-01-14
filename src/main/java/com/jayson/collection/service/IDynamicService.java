package com.jayson.collection.service;

import com.jayson.collection.domain.common.WrapResListEntity;

/**
 * anchor: jayson
 * date: 2018/12/26
 * description:
 */
public interface IDynamicService {
    /**
     * 根据用户id查找动态列表
     *
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    WrapResListEntity selectListsByUserId(String userId, int currentPage, int pageSize);
}
