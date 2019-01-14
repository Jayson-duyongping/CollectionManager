package com.jayson.collection.service.impl;

import com.jayson.collection.constant.CodeStatus;
import com.jayson.collection.dao.DynamicDao;
import com.jayson.collection.domain.Dynamic;
import com.jayson.collection.domain.common.WrapResListEntity;
import com.jayson.collection.service.IDynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * anchor: jayson
 * date: 2019/1/14
 * description:动态心情的实现逻辑
 */
@Service("dynamicService")
public class DynamicServiceImpl implements IDynamicService {

    @Resource
    private DynamicDao dynamicDao;

    /**
     * 查询最新的用户动态信息(返回的type分类：1图片，2音乐，3书籍)
     *
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public WrapResListEntity selectListsByUserId(String userId, int currentPage, int pageSize) {
        List<Dynamic> dynamics = dynamicDao.selectListsByUserId(userId, currentPage - 1, pageSize);
        WrapResListEntity entity = new WrapResListEntity();
        entity.setCode(CodeStatus.SUCCESS);
        entity.setList(dynamics);
        entity.setCount(dynamics.size());
        entity.setMsg("最新的动态信息");
        return entity;
    }
}
