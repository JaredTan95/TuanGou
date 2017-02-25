package spittr.data.db.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_authorityRepository;
import spittr.data.domain.S_authority;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public class JdbcS_authorityRepository implements S_authorityRepository {
    private static final String INSERT_INTO="INSERT INTO S_authority (s_authid,s_auleavel,s_whodid) VALUES (?,?,?);";
    private static final String SELECT_BY_ID="SELECT s_authid,s_auleavel,s_whodid FROM S_authority WHERE s_authid=?;";
    private static final String SELECT_BY_OPTOR_ID="SELECT s_authid,s_auleavel,s_whodid FROM S_authority WHERE s_whodid=?;";
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean save(S_authority sAuthority) {
        return jdbcOperations
                .update(INSERT_INTO,sAuthority.getS_authid(),sAuthority.getS_auleavel(),sAuthority.getS_whodid())>0;
    }

    @Override
    public List<S_authority> findById(String id) {
        return jdbcOperations.query(SELECT_BY_ID,new S_authorityRowMapper(),id);
    }

    @Override
    public List<S_authority> findByOperator(String OperatorId) {
        return jdbcOperations.query(SELECT_BY_OPTOR_ID,new S_authorityRowMapper(),OperatorId);
    }


    private static final class S_authorityRowMapper implements RowMapper<S_authority>{
        @Override
        public S_authority mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_authority(resultSet.getInt("s_authid"),resultSet.getString("s_auleavel"),resultSet.getString("s_whodid"));
        }
    }
}
