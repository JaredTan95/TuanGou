package spittr.data.db.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_uListendRecRepository;
import spittr.data.domain.S_listendRec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public class JdbcS_uListendRecRepository implements S_uListendRecRepository {
    private static final String INSERT_INTO="INSERT INTO S_listendRec (s_userid,s_songid,s_listendRecNum,s_userLisetenenDate) " +
                                            "VALUES (?,?,?,?);";
    private static final String SELECT_BY_USER_ID="SELECT s_userid,s_songid,s_listendRecNum,s_userLisetenenDate FROM S_listendRec WHERE s_userid=?;";

    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean seva(S_listendRec sListendRec) {
        return jdbcOperations.update(INSERT_INTO
                ,sListendRec.getS_userid(),sListendRec.getS_songid()
                ,sListendRec.getS_listendRecNum(),sListendRec.getS_userLisetenenDate())>0;
    }

    @Override
    public List<S_listendRec> findByUserId(String id) {
        return jdbcOperations.query(SELECT_BY_USER_ID,new S_uListendRecRowMapper(),id);
    }

    private static final class S_uListendRecRowMapper implements RowMapper<S_listendRec>{
        @Override
        public S_listendRec mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_listendRec(resultSet.getString("s_userid"),resultSet.getString("s_songid")
                                    ,resultSet.getInt("s_listendRecNum"),resultSet.getDate("s_userLisetenenDate"));
        }
    }
}
