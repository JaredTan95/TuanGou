import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import data.domain.admininfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.service.userAuthentication;

import java.util.List;

/**
 * Created by tanjian on 2017/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class userAuthTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcadmininfoRepository jdbcadmininfoRepository;
    @Test
    public void findAll(){
        List<admininfo> lists=new userAuthentication(jdbcTemplate).checkLogin();
        for (admininfo item:lists){
            System.out.println(item.toString());
        }
    }
}
