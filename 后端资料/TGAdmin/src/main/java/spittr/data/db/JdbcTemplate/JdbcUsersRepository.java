package spittr.data.db.JdbcTemplate;

import com.google.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_usersRepository;
import spittr.data.domain.S_users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2016/12/30.
 * 基于JdbcTemplate实现的对用户的实体操作类
 */
public class JdbcUsersRepository implements S_usersRepository {
    private static final String SELECT_USER_BY_NAME_PWD = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users WHERE s_uaccount=? AND s_upwd=?;";
    private static final String COUNT = "SELECT s_userid FROM S_users;";
    private static final String SELECT_ONE_BY_USER_ACCOUNT = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users where s_uaccount=?;";
    private static final String SELECT_ONE_BY_USER_ID = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users where s_userid=?;";
    private static final String SELECT_ONE_BY_USER_NICKNAME = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users where s_unickname=?;";
    private static final String SELECT_ALL = "SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users;";
    private static final String INSERT_INTO_USER = "INSERT INTO S_users (s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone) VALUES(?,?,?,?,?,?,?);";
    private static final String SELECT_BY_NICKNAME_REGEXP="SELECT s_userid,s_uaccount,s_upwdsalt,s_upwd,s_unickname,s_uemail,s_unone FROM S_users WHERE s_unickname REGEXP ?";

    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcUsersRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public S_users validateUser(String name, String pwd) {
        return jdbcOperations.queryForObject(SELECT_USER_BY_NAME_PWD, new S_usersRowMapper(), name, pwd);
    }

    @Override
    public long count() {
        return jdbcOperations.queryForList(COUNT).size();
    }

    @Override
    public boolean save(S_users user) {
        return jdbcOperations.update(INSERT_INTO_USER
                , user.getS_userid(), user.getS_uaccount()
                , user.getS_upwdsalt(), user.getS_upwd()
                , user.getS_unickname(), user.getS_uemail()
                , user.getS_unone()) > 0;
    }

    @Override
    public S_users findOne(String id) {
        return jdbcOperations.queryForObject(SELECT_ONE_BY_USER_ID, new S_usersRowMapper(), id);
    }

    @Override
    public S_users findByUserNickname(String nickname) {
        return jdbcOperations.queryForObject(SELECT_ONE_BY_USER_NICKNAME, new S_usersRowMapper(), nickname);
    }

    @Override
    public List<S_users> findByNickName(String nickname) {
        return jdbcOperations.query(SELECT_BY_NICKNAME_REGEXP,new S_usersRowMapper(),nickname);
    }

    //TODO:实现方法
    @Override
    public boolean update(S_users user) {
        return false;
    }

    @Override
    public S_users hasOne(String account) {
        return jdbcOperations.queryForObject(SELECT_ONE_BY_USER_ACCOUNT, new S_usersRowMapper(), account);
    }

    @Override
    public List<S_users> findAll() {
        return jdbcOperations.query(SELECT_ALL, new S_usersRowMapper());
    }

    private static final class S_usersRowMapper implements RowMapper<S_users> {
        @Override
        public S_users mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_users(
                    resultSet.getString("s_userid")
                    , resultSet.getString("s_uaccount")
                    , resultSet.getString("s_upwdsalt")
                    , resultSet.getString("s_upwd")
                    , resultSet.getString("s_unickname")
                    , resultSet.getString("s_uemail")
                    , resultSet.getString("s_unone")
            );
        }
    }
}
