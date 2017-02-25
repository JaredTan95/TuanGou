package data.Repository.JdbcTemplate;

import data.Repository.admininfoRepository;
import data.domain.admininfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/2/24.
 * 通过Spring JdbcTemplate实现Repository接口，从而实现数据持久化
 * 使用方法及参数和返回参见（url）：http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html#method.summary
 */
public class JdbcadmininfoRepository implements admininfoRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcadmininfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    private final static String  INSERT_ADMININFO="INSERT INTO admininfo " +
            "(adminId,adminAccount,adminPwd,adminRegDate,adminLastLoginDate) " +
            "VALUES(?,?,?,?,?);";
    private final static String UPDATE_ADMIN_PWD="UPDATE admininfo SET adminPwd=? WHERE adminId=?;";
    private final static String UPDATE_ADMIN_LASTLOGINDATE="UPDATE admininfo SET adminLastLoginDate=? WHERE adminId=?;";
    private final static String FIND_ONE_ADMIN="SELECT adminId,adminAccount,adminPwd,adminRegDate,adminLastLoginDate FROM admininfo WHERE adminId=?";
    private final static String FIND_ALL="SELECT adminId,adminAccount,adminPwd,adminRegDate,adminLastLoginDate FROM admininfo";
    private final static String DELETE_ADMIN_BY_ID="DELETE FROM admininfo WHERE adminId=?";

    @Override
    public boolean save(admininfo admin) {
        return jdbcTemplate.update(INSERT_ADMININFO,
                    admin.getAdminId(),admin.getAdminAccount()
                    ,admin.getAdminPwd(),admin.getAdminRegDate()
                    ,admin.getAdminLastLoginDate())>0;
    }

    @Override
    public boolean updatePasswd(String passwd,String id) {
        return jdbcTemplate.update(UPDATE_ADMIN_PWD,passwd,id)>0;
    }

    @Override
    public boolean updateLastLoginDate(admininfo admin) {
        return jdbcTemplate.update(UPDATE_ADMIN_LASTLOGINDATE
                            , admin.getAdminLastLoginDate(),admin.getAdminId())>0;
    }

    @Override
    public admininfo findOne(String id) {
        return (admininfo)jdbcTemplate.queryForObject(FIND_ONE_ADMIN,new admininfoRowMapper(),id);
    }

    @Override
    public List<admininfo> findAll() {
        return jdbcTemplate.query(FIND_ALL,new admininfoRowMapper());
    }

    @Override
    public boolean delete(String id) {
        return jdbcTemplate.update(DELETE_ADMIN_BY_ID,id)>0;
    }

    private final static class admininfoRowMapper implements RowMapper{
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return new admininfo(resultSet.getString("adminId")
                        ,resultSet.getString("adminAccount"),resultSet.getString("adminPwd")
                        ,resultSet.getDate("adminRegDate"),resultSet.getDate("adminLastLoginDate"));
        }
    }
}
