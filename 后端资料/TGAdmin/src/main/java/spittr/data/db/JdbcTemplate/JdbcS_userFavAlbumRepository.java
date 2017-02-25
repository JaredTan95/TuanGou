package spittr.data.db.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_userFavAlbumRepository;
import spittr.data.domain.S_userFavAlbum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public class JdbcS_userFavAlbumRepository implements S_userFavAlbumRepository {
    private static final String INSERT_INTO="INSERT INTO S_userFavAlbum (s_aid,s_userid,s_uFavAlbumDate) VALUES (?,?,?);";
    private static final String SELECT_USER_FAV="SELECT s_aid,s_userid,s_uFavAlbumDate FROM S_userFavAlbum WHERE s_userid=?;";
    private static final String SELECT_BY_ALBUMID="SELECT s_aid,s_userid,s_uFavAlbumDate FROM S_userFavAlbum WHERE s_aid=?;";
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean save(S_userFavAlbum userFavAlbum) {
        return jdbcOperations.update(INSERT_INTO
                                ,userFavAlbum.getS_aid()
                                ,userFavAlbum.getS_userid()
                                ,userFavAlbum.getS_uFavAlbumDate())>0;
    }

    @Override
    public List<S_userFavAlbum> findUserFav(String userid) {
        return jdbcOperations.query(SELECT_USER_FAV,new S_userFavAlbumRowMapper(),userid);
    }

    @Override
    public List<S_userFavAlbum> findByAlbumId(String aid) {
        return jdbcOperations.query(SELECT_BY_ALBUMID,new S_userFavAlbumRowMapper(),aid);
    }

    private static final class S_userFavAlbumRowMapper implements RowMapper<S_userFavAlbum> {
        @Override
        public S_userFavAlbum mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_userFavAlbum(
                    resultSet.getString("s_aid")
                    ,resultSet.getString("s_userid")
                    ,resultSet.getDate("s_uFavAlbumDate"));
        }
    }
}
