package spittr.data.db.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_typeRepository;
import spittr.data.domain.S_type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tanjian on 2016/12/31.
 * 基于JdbcTemplate的S_type音乐类型的增删查改
 */
public class JdbcS_typeRepository implements S_typeRepository {
    private static final String INSERT_SONG_TYPE="INSERT INTO S_type" +
            "(s_stid,s_sttitle) values ( ?, ?);";
    private static final String SELECT_SONG_TYPE_BY_ID="SELECT s_stid,s_sttitle FROM S_type WHERE s_stid=?;";
    private static final String SELECT_ALL_SONG_TYPE="SELECT s_stid,s_sttitle FROM S_type;";

    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean save(S_type singer) {
        return jdbcOperations.update(INSERT_SONG_TYPE
                ,singer.getS_stid(),singer.getS_sttitle())>0;
    }

    @Override
    public S_type findOne(String id) {
        return  jdbcOperations.queryForObject(SELECT_SONG_TYPE_BY_ID,new S_typeRowMapper(),id);
    }

    @Override
    public S_type findByUsername(String username) {
        return null;
    }

    @Override
    public List<S_type> findAll() {
        List lists=new ArrayList<S_type>();
        List<Map<String, Object>> listMap= jdbcOperations.queryForList(SELECT_ALL_SONG_TYPE);
        for(int i=0;i<listMap.size();i++){
            S_type type=new S_type(
                    (String)listMap.get(i).get("s_stid")
                    ,(String)listMap.get(i).get("s_sttitle")
            );
            lists.add(type);
        }
        return lists;
    }

    private static final class S_typeRowMapper implements RowMapper<S_type> {
        @Override
        public S_type mapRow(ResultSet resultSet, int i) throws SQLException {
            /*String s_sid, String s_sttitle*/
            return new S_type(
                    resultSet.getString("s_stid")
                    ,resultSet.getString("s_sttitle")
            );
        }
    }
}
