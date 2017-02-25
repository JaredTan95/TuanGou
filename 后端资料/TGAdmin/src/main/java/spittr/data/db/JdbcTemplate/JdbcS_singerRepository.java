package spittr.data.db.JdbcTemplate;

import com.google.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_singerRepository;
import spittr.data.domain.S_singer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 */
public class JdbcS_singerRepository implements S_singerRepository {
    private JdbcOperations jdbcOperations;

    private static final String SELECT_ALL_SINGERS="SELECT s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic FROM S_singer;";
    private static final String SELECT_BY_NAME_REG="SELECT s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic FROM S_singer WHERE s_sname REGEXP ?;";
    private static final String SELECT_BY_ID="SELECT s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic FROM S_singer WHERE s_singerid=?;";
    private static final String COUNT_SINGERS="SELECT s_singerid FROM S_singer;";
    private static final String INSERT_SINGER="INSERT INTO S_singer" +
            "(s_singerid,s_sname,s_sgender,s_singerdescp,s_svisi,s_spic)" +
            "values" +
            "( ?, ?, ?, ?, ?,?);";

    @Inject
    public JdbcS_singerRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations=jdbcOperations;
    }

    @Override
    public long count() {
          return jdbcOperations.queryForList(COUNT_SINGERS).size();
    }

    @Override
    public boolean save(S_singer singer) {
        return jdbcOperations.update(INSERT_SINGER
        ,singer.getS_singerid(),singer.getS_sname()
        ,singer.getS_sgender(),singer.getS_sdescp()
        ,singer.getS_svisi(),singer.getS_spic())>0;
    }

    @Override
    public S_singer findOne(long id) {
        return jdbcOperations.queryForObject(SELECT_BY_ID,new S_singerRowMapper(),id);
    }

    @Override
    public List<S_singer> findByName(String name) {
        return jdbcOperations.query(SELECT_BY_NAME_REG,new S_singerRowMapper(),name);
    }

    @Override
    public List<S_singer> findAll() {
         return jdbcOperations.query(SELECT_ALL_SINGERS,new S_singerRowMapper());
    }

    private static final class S_singerRowMapper implements RowMapper<S_singer>{
        @Override
        public S_singer mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_singer(resultSet.getString("s_singerid")
                                ,resultSet.getString("s_sname")
                                ,resultSet.getInt("s_sgender")
                                ,resultSet.getString("s_singerdescp")
                                ,resultSet.getInt("s_svisi")
                                ,resultSet.getString("s_spic"));
        }
    }
}

