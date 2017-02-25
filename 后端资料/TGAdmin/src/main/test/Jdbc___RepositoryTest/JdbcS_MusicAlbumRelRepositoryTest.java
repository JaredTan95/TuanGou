package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_MusicAlbumRelRepository;
import spittr.data.domain.S_MusicAblumRelationship;

import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_MusicAlbumRelRepositoryTest {
    private JdbcS_MusicAlbumRelRepository jdbcSMusicAlbumRelRepository;

    @Autowired
    public void setJdbcSMusicAlbumRelRepository(JdbcS_MusicAlbumRelRepository jdbcSMusicAlbumRelRepository) {
        this.jdbcSMusicAlbumRelRepository = jdbcSMusicAlbumRelRepository;
    }

    //@Test
    public void insert(){
        assertEquals(true,jdbcSMusicAlbumRelRepository
                .save(new S_MusicAblumRelationship("763gd8eh33984s","99cdfb63635045f4a10f23a79f17a0f5")));
    }

    @Test
    public void findByAlbumId(){
        List lists=jdbcSMusicAlbumRelRepository.findByAlbumId("12422");
        for(Object list:lists){
            System.out.println(list.toString());
        }
        assertEquals("37263",jdbcSMusicAlbumRelRepository.findByAlbumId("12422").get(0).getS_songid());
    }

    @Test
    public void findBySongId(){
        List lists=jdbcSMusicAlbumRelRepository.findBySongId("37263");
        for(Object list:lists){
            System.out.println(list.toString());
        }
        assertEquals("12422",jdbcSMusicAlbumRelRepository.findBySongId("37263").get(0).getS_aid());
    }
}
