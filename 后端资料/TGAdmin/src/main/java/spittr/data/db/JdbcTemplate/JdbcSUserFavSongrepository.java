package spittr.data.db.JdbcTemplate;

import com.google.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_userFavSongRepository;
import spittr.data.domain.S_userFavSong;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 * 用户收藏单曲操作类
 */
public class JdbcSUserFavSongrepository implements S_userFavSongRepository {
    private static String COUNT="SELECT COUNT(*) FROM S_userFavSong;";
    private static String InSERT_INTO="INSERT INTO S_userFavSong (s_songid,s_userid,s_uFavSongDate) VALUES (?,?,?);";
    private static String SELECT_USERS_FAV="SELECT * FROM S_song,S_userFavSong WHERE S_userFavSong.s_songid=S_song.s_songid AND S_userFavSong.s_userid=?;";
    private static String SELECT_BY_SONGID="SELECT s_songid,s_userid,s_uFavSongDate FROM S_userFavSong WHERE s_songid=?;";
    private static String FIND_ISEXSITS="SELECT s_songid,s_userid FROM S_userFavSong WHERE s_songid=? AND s_userid=?;";
    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSUserFavSongrepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public long count() {
        return jdbcOperations.queryForList(COUNT).size();
    }

    @Override
    public boolean save(S_userFavSong sUserFavSong) {
        return jdbcOperations.update(InSERT_INTO
                                    ,sUserFavSong.getS_songid()
                                    ,sUserFavSong.getS_userid()
                                    ,sUserFavSong.getS_uFavSongDate())>0;
    }


    @Override
    public List findUsersFav(String userid) {
        return jdbcOperations.queryForList(SELECT_USERS_FAV,userid);
    }

    @Override
    public List findBySongId(String s_songid) {
        return jdbcOperations.query(SELECT_BY_SONGID,new S_userFavSongRowMapper(),s_songid);
    }

    @Override
    public boolean isExsits(S_userFavSong sUserFavSong) {
        return jdbcOperations.queryForList(FIND_ISEXSITS,sUserFavSong.getS_songid(),sUserFavSong.getS_userid()).size()>0;
    }

    private static final class S_userFavSongRowMapper implements RowMapper<S_userFavSong> {
        @Override
        public S_userFavSong mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_userFavSong(
                    resultSet.getString("s_songid")
                    ,resultSet.getString("s_userid")
                    ,resultSet.getDate("s_uFavSongDate")
            );
        }
    }
}
