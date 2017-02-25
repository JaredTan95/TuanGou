package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_uListendRecRepository;
import spittr.data.domain.S_listendRec;
import spittr.utils.UUIDGenerator;

import java.util.Date;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_uListendRecRepositoryTest {
    private JdbcS_uListendRecRepository jdbcSUListendRecRepository;

    @Autowired
    public void setJdbcSUListendRecRepository(JdbcS_uListendRecRepository jdbcSUListendRecRepository) {
        this.jdbcSUListendRecRepository = jdbcSUListendRecRepository;
    }


    @Test
    public void saveRec(){
        assertEquals(true,jdbcSUListendRecRepository
                .seva(new S_listendRec(UUIDGenerator.getUUID(),
                        UUIDGenerator.getUUID(),233,new Date())));
    }

    @Test
    public void findUserListenRec(){
        System.out.println("findUserListenRec[0]:"+jdbcSUListendRecRepository.findByUserId("85dea119f9b34122b1950e9d04333f2b").get(0).toString());
    }
}
