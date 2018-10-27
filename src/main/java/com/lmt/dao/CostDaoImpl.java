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
@Repository(value = "costDao")
public class CostDaoImpl implements CostDao{
    @Resource
    private JdbcTemplate template;
    public List<Cost> findAll() {
        String sql="select * from cost";
        CostRowMapper rowMapper=new CostRowMapper();
        List<Cost> list=template.query(sql,rowMapper);
        return list;
    }

    public void save(Cost cost){
        if(cost == null){
            return;
        }
        String sql = "insert into cost values(cost_seq.nextval,?,?,?,?,'1',?,sysdate,null,?)";
        Object[] params={cost.getName(),cost.getBase_duration(),cost.getBase_cost(),cost.getUnit_cost(),
                        cost.getDescr(),cost.getCost_type()};
        template.update(sql,params);
    }

    //空指针异常？？？
    public int findTotalPage(int pageSize){
        String sql="select count(*) from cost";
        Integer rows=template.queryForObject(sql,Integer.class);
        if(rows%pageSize == 0){
            return rows/pageSize;
        }else{
            return rows/pageSize+1;
        }
    }

    public List<Cost> findByPage(int page, int pageSize){
        String sql="select * from (select c.*,rownum r from cost c where rownum<? )where r>?";
        int nextMin = page*pageSize + 1;
        int lastMax = (page-1)*pageSize;
        Object[] params={nextMin,lastMax};
        CostRowMapper rowMapper=new CostRowMapper();
        List<Cost> list=template.query(sql,rowMapper,params);
        return list;
    }
}
