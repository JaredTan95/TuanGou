package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spittr.data.db.JdbcTemplate.JdbcS_authorityRepository;
import spittr.data.domain.S_authority;
import spittr.utils.UUIDGenerator;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_authorityRepositorytest {

    private JdbcS_authorityRepository jdbcSAuthorityRepository;

    @Autowired
    public void setJdbcSAuthorityRepository(JdbcS_authorityRepository jdbcSAuthorityRepository) {
        this.jdbcSAuthorityRepository = jdbcSAuthorityRepository;
    }

    //@Test
    @Transactional
    public void save(){
        assertEquals(true,jdbcSAuthorityRepository.save(
                new S_authority((Integer.parseInt(UUIDGenerator.getUUID())),"8",UUIDGenerator.getUUID())));
    }

    @Test
    public void findById(){
        System.out.println("findById[0]:"+jdbcSAuthorityRepository.findById("1157793070").get(0).toString());
    }

    @Test
    public void findByOperator(){
        System.out.println("findByOperator[0]:"+jdbcSAuthorityRepository.findByOperator("e317252964a04d6eb0d2d58959736734").toString());
    }
}
