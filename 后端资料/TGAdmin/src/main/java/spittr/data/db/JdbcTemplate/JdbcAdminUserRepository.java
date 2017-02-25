package spittr.data.db.JdbcTemplate;

import com.google.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.data.db.adminUserRepository;
import spittr.data.domain.adminUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2016/12/30.
 * JdbcAdminUserRepository
 */
@Repository
public class JdbcAdminUserRepository implements adminUserRepository {
    private JdbcOperations jdbcOperations;
    private static final String INSERT_ADMINUSER="insert into adminUser" +
            "(s_adminid,s_authid,s_adminaccount,s_adminPwd,s_adminLogininDate)" +
            "values" +
            "( ?, ?, ?, ?, ?);";

    private static final String SELECT_ADMINUSER_BY_ID="SELECT * FROM adminUser" +
            "WHERE s_adminid=?;";
    private static final String SELECT_ADMINUSER_BY_NAME_PWD="SELECT * FROM adminUser WHERE s_adminaccount= ? AND s_adminPwd= ?;";

    @Inject
    public JdbcAdminUserRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public adminUser save(adminUser adminuser) {
        return null;
    }

    public boolean addAdminUser(adminUser adminUser){
        return jdbcOperations.update(INSERT_ADMINUSER,
                adminUser.getS_adminid()
                , adminUser.getS_authid()
                , adminUser.getS_adminaccount()
                , adminUser.getS_adminPwd()
                , adminUser.getS_adminLogininDate()) > 0;
    }

    @Override
    public adminUser findOne(long id) {
        return jdbcOperations.queryForObject(SELECT_ADMINUSER_BY_ID,new AdminUserRowMapper(),id);
    }

    public adminUser validateOne(String name,String pwd){
        return jdbcOperations.queryForObject(SELECT_ADMINUSER_BY_NAME_PWD,new AdminUserRowMapper(),name,pwd);
    }

    @Override
    public adminUser findByUsername(String username) {
        return null;
    }

    @Override
    public List<adminUser> findAll() {
        return null;
    }

    private static final class AdminUserRowMapper implements RowMapper<adminUser>{
        @Override
        public adminUser mapRow(ResultSet resultSet, int i) throws SQLException {
/*
            String s_adminid, int s_authid, String s_adminaccount, String s_adminPwd, Date s_adminLogininDate
*/
            return new adminUser(
                    resultSet.getString("s_adminid")
                    ,resultSet.getInt("s_authid")
                    ,resultSet.getString("s_adminaccount")
                    ,resultSet.getString("s_adminPwd")
                    ,resultSet.getDate("s_adminLogininDate")
            );
        }
    }
}
