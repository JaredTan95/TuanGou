package DAOJunitTest;



import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import data.domain.admininfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;

/**
 * Created by tanjian on 2017/2/24.
 * Junit测试JdbcadmininfoRepository的操作方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcadminRepositoryTest {
    @Autowired
    private JdbcadmininfoRepository jdbcadmininfoRepository;


    @Test
    public void findOneTest(){
        assertEquals("test",jdbcadmininfoRepository.findOne(new admininfo("123",null,null,null,null)).getAdminAccount());
    }
}
