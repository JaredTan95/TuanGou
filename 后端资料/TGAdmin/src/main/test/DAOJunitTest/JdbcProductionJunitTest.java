package DAOJunitTest;

import data.Repository.JdbcTemplate.JdbcproductinfoRepository;
import data.domain.productinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Allen on 2017/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcProductionJunitTest {
    @Autowired
//    private JdbcproductinfoRepository jdbcproductinfoRepository;
    @Test
    public void save(){
//        productinfo proinfo=new productinfo()
    }

}
