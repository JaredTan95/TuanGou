package spittr.data.db.JdbcTemplate;

import com.google.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_MusicAlbumRelRepository;
import spittr.data.domain.S_MusicAblumRelationship;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public class JdbcS_MusicAlbumRelRepository implements S_MusicAlbumRelRepository {
    private static final String INSERT_INTO="INSERT INTO S_MusicAblumRelationship (s_aid,s_songid) VALUES (?,?);";
    private static final String SELECT_BY_ALBUM_ID="SELECT s_aid,s_songid FROM S_MusicAblumRelationship WHERE s_aid=?;";
    private static final String SELECT_BY_SONG_ID="SELECT s_aid,s_songid FROM S_MusicAblumRelationship WHERE s_songid=?;";

    private static final String SELECT_MUSIC_BY_RELATION="SELECT musAlRel.s_aid,s.s_songid,s.s_singerid,s.s_title,S_singer.s_sname,S_albums.s_atitle,s.s_surl,s.s_visited,s.s_visitedTotal,s.s_dloaded,s.s_scover,s.s_smvurl,s.s_songdescp FROM S_MusicAblumRelationship musAlRel, S_song s, S_singer, S_albums WHERE musAlRel.s_songid=s.s_songid AND S_singer.s_singerid=s.s_singerid AND S_albums.s_aid=musAlRel.s_aid AND musAlRel.s_aid=?";
    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcS_MusicAlbumRelRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }
    @Override
    public boolean save(S_MusicAblumRelationship musicAblumRelationship) {
        return jdbcOperations.update(INSERT_INTO,musicAblumRelationship.getS_aid(),musicAblumRelationship.getS_songid())>0;
    }

    @Override
    public List<S_MusicAblumRelationship> findByAlbumId(String id) {
        return jdbcOperations.query(SELECT_BY_ALBUM_ID,new S_MusicAlbumRelRowMapper(),id);
    }

    @Override
    public List<S_MusicAblumRelationship> findBySongId(String id) {
        return jdbcOperations.query(SELECT_BY_SONG_ID,new S_MusicAlbumRelRowMapper(),id);
    }

    @Override
    public List selectRelaByAlbumId(String id) {
        return jdbcOperations.queryForList(SELECT_MUSIC_BY_RELATION,id);
    }


    private static final class S_MusicAlbumRelRowMapper implements RowMapper<S_MusicAblumRelationship>{
        @Override
        public S_MusicAblumRelationship mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_MusicAblumRelationship(resultSet.getString("s_aid"),resultSet.getString("s_songid"));
        }
    }
}
