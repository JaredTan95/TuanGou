package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_albumsRepository;
import spittr.data.domain.S_albums;
import spittr.utils.UUIDGenerator;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tanjian on 2016/12/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_albumsRepositoryTest {
    @Autowired
    private JdbcS_albumsRepository jdbcSAlbumsRepository;

    //@Test
    public void add(){
        S_albums album=new S_albums(UUIDGenerator.getUUID(),"201629739"
                    ,"test",new Date()
                    ,"发行时间：2015-01-28 发行公司： Two Steps From Hell",46,"123.207.83.185/SpittrResources/MusicLibs/albumCover/Legacy.jpg");
        assertEquals(true,jdbcSAlbumsRepository.save(album));
    }

    @Test
    public void count(){
        System.out.println("Albums Count:"+jdbcSAlbumsRepository.count());
    }

    @Test
    public void getAll(){
        List lists=jdbcSAlbumsRepository.findAll();
        System.out.println(lists.toArray().toString());
    }

    @Test
    public void orderByPubTime(){
        List lists=jdbcSAlbumsRepository.orderByPubTime();
        System.out.println("orderByPubTime:"+lists.get(0).toString());
    }

    @Test
    public void findSingerById(){
        System.out.println("findSingerById:"+jdbcSAlbumsRepository.findSingerById("201629739").get(0).toString());
    }

    @Test
    public void findById(){
        assertEquals("Game Of Thrones"
                    ,jdbcSAlbumsRepository.findById("591f525b45244409bd606f5ba8db06c4").getS_atitle());
    }

    @Test
    public void findByName(){
        List<S_albums> lists=jdbcSAlbumsRepository.findByTitle("dog");
        for(S_albums item:lists){
            System.out.println("模糊查询到专辑："+item.toString());
        }
    }
}
