import com.lmt.dao.CostDao;
import com.lmt.entity.Cost;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/24.
 */
public class Test {
    public static void main(String[] args){
        String conf="classpath:applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);

        CostDao costdao=ac.getBean("costDao",CostDao.class);
        List<Cost> list=costdao.findAll();
        for (Cost cost:list) {
            System.out.println(cost.getName());
        }
    }
}
