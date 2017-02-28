package DAOJunitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.OutOrderNum;

/**
 * Created by tanjian on 2017/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcOrserRepositoryTest {
    @Test
    public void saveOrder(){
        System.out.println(new OutOrderNum().OrderNum());
    }
}
