package spittr.data.db.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_MusicCategoryRepository;
import spittr.data.domain.S_MusicCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public class JdbcS_MusicCategoryRepository implements S_MusicCategoryRepository {
    private static final String INSERT_INTO="INSERT INTO S_MusicCategory (s_songid,s_stid) VALUES (?,?);";
    private static final String SELECT_BY_SONGID="SELECT s_songid,s_stid FROM S_MusicCategory WHERE s_songid=?;";
    private static final String SELECT_BY_TYPEID="SELECT s_songid,s_stid FROM S_MusicCategory WHERE s_stid=?;";

    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean Save(S_MusicCategory sMusicCategory) {
        return jdbcOperations.update(INSERT_INTO, sMusicCategory.getS_songid(),sMusicCategory.getS_stid())>0;
    }

    @Override
    public List<S_MusicCategory> findBySongId(String songId) {
        return jdbcOperations.query(SELECT_BY_SONGID,new S_MusicCategoryRowMapper(),songId);
    }

    @Override
    public List<S_MusicCategory> findSongsByCatId(String typeId) {
        return jdbcOperations.query(SELECT_BY_TYPEID,new S_MusicCategoryRowMapper(),typeId);
    }

    private static final class S_MusicCategoryRowMapper implements RowMapper<S_MusicCategory>{
        @Override
        public S_MusicCategory mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_MusicCategory(resultSet.getString("s_songid"),resultSet.getString("s_stid"));
        }
    }
}
