import Jdbc___RepositoryTest.JdbcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spittr.data.db.JdbcTemplate.JdbcS_MusicAlbumRelRepository;
import spittr.data.db.JdbcTemplate.JdbcS_songRepository;
import spittr.data.domain.S_MusicAblumRelationship;
import spittr.data.domain.S_song;
import spittr.utils.UUIDGenerator;

/**
 * Created by tanjian on 2017/1/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcAddOneMusicTransactionTest {
    private JdbcS_MusicAlbumRelRepository jdbcSMusicAlbumRelRepository;
    @Autowired
    private JdbcS_songRepository jdbcSSongRepository;

    @Autowired
    public void setJdbcSMusicAlbumRelRepository(JdbcS_MusicAlbumRelRepository jdbcSMusicAlbumRelRepository) {
        this.jdbcSMusicAlbumRelRepository = jdbcSMusicAlbumRelRepository;
    }

    @Test
    @Transactional
    public void InsertTransAction(){
        String songid=UUIDGenerator.getUUID();
        S_song song=new S_song(songid,"201629739"
                ,"Jump!","123.207.83.185/SpittrResources/MusicLibs/mp3/Jump.mp3"
                ,1,110,1,"123.207.83.185/SpittrResources/MusicLibs/albumCover/Legacy.jpg","","");
         S_MusicAblumRelationship sMusicAblumRelationship=new S_MusicAblumRelationship("ec9c03fa648a4103be1eaf20c9e206ef",songid);

         jdbcSSongRepository.save(song);
         jdbcSMusicAlbumRelRepository.save(sMusicAblumRelationship);
    }
}
