package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spittr.data.db.JdbcTemplate.JdbcS_userCommentRepository;
import spittr.data.domain.S_userComment;
import spittr.utils.UUIDGenerator;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_userCommentRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private JdbcS_userCommentRepository jdbcSUserCommentRepository;

    @Autowired
    public void setJdbcSUserCommentRepository(JdbcS_userCommentRepository jdbcSUserCommentRepository) {
        this.jdbcSUserCommentRepository = jdbcSUserCommentRepository;
    }

    @Test
    @Transactional
    public void insertComment(){
        assertEquals(true,
                jdbcSUserCommentRepository.save(new S_userComment("13221"
                        , UUIDGenerator.getUUID(),"Junit单元测试插入值"
                        ,new Date())));
    }

    @Test
    public void findBySongId(){
        assertEquals("13221",jdbcSUserCommentRepository.findBySongId("37263").get(0).getS_userid());
    }
}
