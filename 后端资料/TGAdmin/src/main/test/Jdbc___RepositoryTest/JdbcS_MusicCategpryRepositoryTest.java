package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_MusicCategoryRepository;
import spittr.data.domain.S_MusicCategory;
import spittr.utils.UUIDGenerator;

import static org.junit.Assert.assertEquals;

/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_MusicCategpryRepositoryTest {
    private JdbcS_MusicCategoryRepository jdbcSMusicCategoryRepository;

    @Autowired
    public void setJdbcSMusicCategoryRepository(JdbcS_MusicCategoryRepository jdbcSMusicCategoryRepository) {
        this.jdbcSMusicCategoryRepository = jdbcSMusicCategoryRepository;
    }

    @Test
    public void save(){
        assertEquals(true,jdbcSMusicCategoryRepository.Save(
                new S_MusicCategory(UUIDGenerator.getUUID(),UUIDGenerator.getUUID())));
    }

    @Test
    public void findBySongId(){
        System.out.println("SMusicCategory--findBySongId[0]:"+jdbcSMusicCategoryRepository.findBySongId("3fa92b16497645729b816ca909ea22d3").get(0).toString());
    }

    @Test
    public void findSongsByCatId(){
        System.out.println("SMusicCategory--findSongsByCatId[0]:"+jdbcSMusicCategoryRepository.findSongsByCatId("00eb5715988340d5b6feca9ec2da9f76").get(0).toString());
    }
}
