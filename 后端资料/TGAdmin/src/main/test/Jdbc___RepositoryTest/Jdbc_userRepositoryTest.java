package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcUsersRepository;
import spittr.data.domain.S_users;

import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2017/1/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class Jdbc_userRepositoryTest {
    @Autowired
    private JdbcUsersRepository jdbcUsersRepository;

    @Test
    public void hasOne(){
        assertEquals("fe7ed0503509d1a190aadb3b7fb9fbf26c201bb49e123e3e3be3d0ab35be62f8",jdbcUsersRepository.hasOne("tanjian").getS_upwd());
    }

    @Test
    public void findOne(){
        assertEquals("tanjian",jdbcUsersRepository.findOne("a81318bebd16447db8fb479245f011b1").getS_uaccount());
    }

    @Test
    public void nicknameIsExists(){
        assertEquals("谭建",jdbcUsersRepository.findByUserNickname("谭建").getS_unickname());
    }

    @Test
    public void listAll(){
        List<S_users> lists= jdbcUsersRepository.findAll();
        for(S_users item:lists){
            System.out.println("用户:"+item.toString());
        }
    }

    @Test
    public void findByRegEXp(){
        List<S_users> lists= jdbcUsersRepository.findByNickName("建");
        for(S_users item:lists){
            System.out.println("模糊查询到用户:"+item.toString());
        }
    }
}
