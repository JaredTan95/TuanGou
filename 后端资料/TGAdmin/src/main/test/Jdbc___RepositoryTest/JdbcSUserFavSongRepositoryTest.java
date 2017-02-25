package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcSUserFavSongrepository;
import spittr.data.domain.S_userFavSong;
import spittr.utils.UUIDGenerator;

import java.util.Date;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcSUserFavSongRepositoryTest {
    private JdbcSUserFavSongrepository jdbcSUserFavSongrepository;

    @Autowired
    public void setJdbcSUserFavSongrepository(JdbcSUserFavSongrepository jdbcSUserFavSongrepository) {
        this.jdbcSUserFavSongrepository = jdbcSUserFavSongrepository;
    }

    @Test
    public void save(){
        S_userFavSong sUserFavSong=new S_userFavSong(UUIDGenerator.getUUID(),"342",new Date());
        assertEquals(true,jdbcSUserFavSongrepository.save(sUserFavSong));
    }

    //@Test
    public void findOne(){
       // TODO:
       // System.out.println("findUsersFav:"+jdbcSUserFavSongrepository.findUsersFav("13221").toString());
    }

    //@Test
    public void findBySongId(){
        //TODO:
       // System.out.println("findBySongId:"+jdbcSUserFavSongrepository.findBySongId("3231").toString());
    }

    @Test
    public void count(){
        System.out.println("SUserFavSong:count():"+jdbcSUserFavSongrepository.count());
    }
}
