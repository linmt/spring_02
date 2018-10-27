package com.lmt.dao;

import com.lmt.entity.Cost;

import java.util.List;

/**
 * Created by 热带雨林 on 2018/10/27.
 */
public interface CostDao {
    List<Cost> findAll();

    List<Cost> findByPage(int page, int pageSize);

    int findTotalPage(int pageSize);

    void save(Cost cost);
}
