import com.lmt.dao.CostDao;
import com.lmt.entity.Cost;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/24.
 */
public class MyTest extends BaseJunit4Test{
    @Resource  //自动注入,默认按名称
    private CostDao costdao;
    @Test   //标明是测试方法
    //@Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void find( ) {
        List<Cost> list=costdao.findAll();
        for (Cost cost:list) {
            System.out.println(cost.getName());
        }
    }
}
