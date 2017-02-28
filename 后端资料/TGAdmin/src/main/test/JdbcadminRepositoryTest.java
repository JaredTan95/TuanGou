import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import data.Repository.JdbcTemplate.JdbcorderinfoRepository;
import data.domain.admininfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.UUIDGenerator;
import utils.sha256;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tanjian on 2017/2/24.
 * Junit测试JdbcadmininfoRepository的操作方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcadminRepositoryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private JdbcOperations jdbcOperations;

    @Autowired
    private JdbcadmininfoRepository jdbcadmininfoRepository;


    //@Test
    public void findOneTest(){
       // assertEquals("test",jdbcadmininfoRepository.findOne(new admininfo("123",null,null,null,null)).getAdminAccount());
    }

   // @Test
    public void saveTest(){
        /*
        * 注意：id采用UUID生成工具生成，而用户密码则采用sha_256(pwd+sha_256(name))算法进行不可逆加密存放入数据库，如果忘记密码，只能重置；
        * */
        try {
            jdbcadmininfoRepository.save(new admininfo(UUIDGenerator.getUUID(),"admin",
                    sha256.encrypted("admin"+sha256.encrypted("admin")),new Date(),new Date()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testCount(){
        System.out.println(jdbcTemplate.queryForObject("SELECT count(*) from productionCategory",Integer.class));
    }


    @Test
    public void testPagenation(){
        List<Map<String, Object>> lists=new JdbcorderinfoRepository(jdbcTemplate).getPageListAllCol("",10,5);
        for(Map<String, Object> item:lists){
            System.out.println(item.toString());
        }
    }
}
