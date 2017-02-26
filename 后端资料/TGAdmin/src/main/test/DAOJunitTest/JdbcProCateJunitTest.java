package DAOJunitTest;


import data.Repository.JdbcTemplate.JdbcproductionCategoryRepository;
import data.domain.productionCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.UUIDGenerator;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Allen on 2017/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcProCateJunitTest {
    @Autowired
    private JdbcproductionCategoryRepository jdbcproductionCategoryRepository;
    @Test
    public void save(){
        productionCategory pc=new productionCategory(UUIDGenerator.getUUID(),"服装");
        assertEquals(true, jdbcproductionCategoryRepository.save(pc));
    }

}
