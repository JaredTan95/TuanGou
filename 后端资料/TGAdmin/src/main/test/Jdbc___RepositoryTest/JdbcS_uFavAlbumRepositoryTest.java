package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_userFavAlbumRepository;
import spittr.data.domain.S_userFavAlbum;
import spittr.utils.UUIDGenerator;

import java.util.Date;

import static org.junit.Assert.assertEquals;
/**
 * Created by tanjian on 2017/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_uFavAlbumRepositoryTest {
    private JdbcS_userFavAlbumRepository jdbcSUserFavAlbumRepository;

    @Autowired
    public void setJdbcSUserFavAlbumRepository(JdbcS_userFavAlbumRepository jdbcSUserFavAlbumRepository) {
        this.jdbcSUserFavAlbumRepository = jdbcSUserFavAlbumRepository;
    }

    //@Test
    public void save(){
        assertEquals(true,jdbcSUserFavAlbumRepository
                .save(new S_userFavAlbum(UUIDGenerator.getUUID(),
                        "13221",new Date())));
    }

    @Test
    public void findUserFav(){
        assertEquals("4da2fa2687284e81b6c10662a9743472",
                jdbcSUserFavAlbumRepository.findUserFav("13221")
                        .get(0).getS_aid());
    }

    @Test
    public void findByAlbumId(){
        assertEquals("13221",
                jdbcSUserFavAlbumRepository.findByAlbumId("4da2fa2687284e81b6c10662a9743472")
                        .get(0).getS_userid());
    }
}
