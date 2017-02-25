import Jdbc___RepositoryTest.JdbcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_albumsRepository;
import spittr.data.db.JdbcTemplate.JdbcS_singerRepository;
import spittr.data.db.JdbcTemplate.JdbcS_songRepository;
import spittr.data.db.JdbcTemplate.JdbcUsersRepository;
import spittr.data.domain.S_albums;
import spittr.data.domain.S_singer;
import spittr.data.domain.S_song;
import spittr.data.domain.S_users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanjian on 2017/1/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class serviceTest {
    @Autowired
    private JdbcUsersRepository jdbcUsersRepository;

    @Autowired
    private JdbcS_singerRepository jdbcSSingerRepository;

    @Autowired
    private JdbcS_albumsRepository jdbcSAlbumsRepository;

    @Autowired
    private JdbcS_songRepository jdbcSSongRepository;
    @Test
    public void search(){
        String q="dog";
        //搜索单曲
        List<S_song> qSongLists=jdbcSSongRepository.findByTitle(q);
        //搜索专辑
        List<S_albums> qAlbumLists=jdbcSAlbumsRepository.findByTitle(q);
        //搜索歌手
        List<S_singer> qSingerLists=jdbcSSingerRepository.findByName(q);
        //搜索用户
        List<S_users> qUserLists=jdbcUsersRepository.findByNickName(q);
        Map<String,List> maps=new HashMap<>();
        maps.put("songLists",qSongLists);
        maps.put("albumLists",qAlbumLists);
        maps.put("singerLists",qSingerLists);
        maps.put("userLists",qUserLists);

        for(S_song item:qSongLists){
            System.out.println("模糊查询到单曲："+item.toString());
        }

        for(S_albums item:qAlbumLists){
            System.out.println("模糊查询到专辑："+item.toString());
        }

        for(S_users item:qUserLists){
            System.out.println("模糊查询到用户："+item.toString());
        }
        for(S_singer item:qSingerLists){
            System.out.println("模糊查询到歌手："+item.toString());
        }
    }
}
