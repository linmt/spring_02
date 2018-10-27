import com.lmt.dao.CostDaoImpl;
import com.lmt.entity.Cost;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/24.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String conf="classpath:applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);

//        CostDao costdao=ac.getBean("costDao",CostDao.class);
//        List<Cost> list=costdao.findAll();
//        for (Cost cost:list) {
//            System.out.println(cost.getName());
//        }

//        CostDao costdao=ac.getBean("costDao",CostDao.class);
//        Timestamp ts =Timestamp.valueOf("2018-09-23 20:03:48");
//        Cost cost=new Cost(null,"包月",null,1000.00,null,"1","包月很爽",ts,null,"1");
//        costdao.save(cost);

//        CostDao costdao=ac.getBean("costDao",CostDao.class);
//        int page=costdao.findTotalPage(3);
//        System.out.println(page);

        CostDaoImpl costdao=ac.getBean("costDaoImpl", CostDaoImpl.class);
        List<Cost> list=costdao.findByPage(1,3);
        for (Cost cost:list) {
            System.out.println(cost.getName());
        }
    }
}
