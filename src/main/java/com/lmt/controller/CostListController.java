package com.lmt.controller;

import com.lmt.dao.CostDao;
import com.lmt.dao.CostDaoImpl;
import com.lmt.entity.Cost;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 热带雨林 on 2018/10/27.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/cost")
public class CostListController{
    @Resource
    private CostDao costDao;

    @RequestMapping("/list.form")
    public String findCost(HttpServletRequest request, HttpServletResponse response,ModelMap model)
            throws Exception {
        int page;
        if(request.getParameter("page")==null){
            page=1;
        }else {
            page=Integer.parseInt(request.getParameter("page"));
        }
        int pageSize=3;
        int totalPage=costDao.findTotalPage(pageSize);
        List<Cost> list=costDao.findByPage(page,pageSize);
        model.put("page", page);
        model.put("totalPage", totalPage);
        model.put("costs", list);
        return "cost/cost_list";
    }
}
