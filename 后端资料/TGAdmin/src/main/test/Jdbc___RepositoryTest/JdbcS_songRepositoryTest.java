package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_songRepository;
import spittr.data.domain.S_song;
import spittr.utils.UUIDGenerator;

import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2016/12/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_songRepositoryTest {
    @Autowired
    private JdbcS_songRepository jdbcSSongRepository;

    //@Test
    public void addOne(){
        S_song song=new S_song(UUIDGenerator.getUUID(),"4ff2f3ab0ad645528f969816672963ce"
                                ,"test","123.207.83.185/SpittrResources/MusicLibs/mp3/Time-Will-Tell.mp3"
                ,1,1,1,"123.207.83.185/SpittrResources/MusicLibs/musicCover/X-Ray-Dog.jpg","","");
        assertEquals(true,jdbcSSongRepository.save(song));
    }

    @Test
    public void countMusicNum(){
        System.out.println("当前单曲数量："+jdbcSSongRepository.count());
    }

    @Test
    public void getAll(){
        List lists=jdbcSSongRepository.findAll();
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
    }

    @Test
    public void findById(){
        System.out.println("findById():Load mp3Url---:"+jdbcSSongRepository.findBySongId("37263").getS_surl());
    }

    @Test
    public void findBySingerId(){
        assertEquals("37263",jdbcSSongRepository.findBySingerId("201629739").getS_songid());
    }
}
