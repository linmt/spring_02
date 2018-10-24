package com.lmt.dao;

import com.lmt.entity.Cost;
import com.lmt.entity.CostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/23.
 */
@Repository
public class CostDao {
    @Resource
    private JdbcTemplate template;
    public List<Cost> findAll() {
        String sql="select * from cost";
        CostRowMapper rowMapper=new CostRowMapper();
        List<Cost> list=template.query(sql,rowMapper);
        return list;
    }
}
