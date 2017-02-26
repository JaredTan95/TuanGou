package data.Repository.JdbcTemplate;

import data.Repository.sellerRepository;
import data.domain.sellers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Allen on 2017/2/25.
 */
public class JdbcsellerRepository implements sellerRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcsellerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*增删改查*/
    private static final String INSERT_SELLER="INSERT INTO sellers(sellerId,sellerTitle,sellerAccount,sellerPwd" +
            ",sellerDscp,sellerLevel,sellerRegDate,sellerPhoneNum,sellerStatus) " +
            "values(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_SELLER_PWD="UPDATE sellers set sellerPwd=?";
    private static final String UPDATE_SELLER="UPDATE sellers SET sellerTitle=?,sellerAccount=?,sellerPwd=?,sellerDscp=?" +
            ",sellerLevel=?,sellerRegDate=?,sellerPhoneNum=?,sellerStatus=?";
    private static final String FINDONE_SELLER="SELECT sellerId,sellerTitle,sellerAccount,sellerPwd" +
            ",sellerDscp,sellerLevel,sellerRegDate,sellerPhoneNum,sellerStatus FROM sellers WHERE sellerId=?";
    private static final String FINDALL_SELLER="SELECT sellerId,sellerTitle,sellerAccount,sellerPwd" +
            ",sellerDscp,sellerLevel,sellerRegDate,sellerPhoneNum,sellerStatus";
    private static final String DELETE_SELLER="DELETE FROM sellers WHERE sellerId=?";


    @Override
    public boolean save(sellers ser) {
        return jdbcTemplate.update(INSERT_SELLER,ser.getSellerId(),ser.getSellerTitle(),ser.getSellerAccount()
                ,ser.getSellerPwd(),ser.getSellerDscp(),ser.getSellerLevel(),ser.getSellerRegDate()
                ,ser.getSellerPhoneNum(),ser.getSellerStaus())>0;
    }

    @Override
    public boolean updatePasswd(sellers ser) {
        return jdbcTemplate.update(UPDATE_SELLER_PWD,ser.getSellerPwd())>0;
    }

    @Override
    public boolean update(sellers ser) {
        return jdbcTemplate.update(UPDATE_SELLER,ser.getSellerId(),ser.getSellerTitle(),ser.getSellerAccount()
                ,ser.getSellerPwd(),ser.getSellerDscp(),ser.getSellerLevel(),ser.getSellerRegDate()
                ,ser.getSellerPhoneNum(),ser.getSellerStaus())>0;
    }

    @Override
    public sellers findOne(String id) {
        return (sellers)jdbcTemplate.query(FINDONE_SELLER,new sellersRowMapper(),id);
    }

    @Override
    public List<sellers> findAll() {
        return jdbcTemplate.query(FINDALL_SELLER,new sellersRowMapper());
    }

    @Override
    public boolean delete(String id) {
        return jdbcTemplate.update(DELETE_SELLER,id)>0;
    }

    private static final class sellersRowMapper implements RowMapper{
        /*String sellerId, String sellerTitle, String sellerAccount, String sellerPwd, String sellerDscp,
                   double sellerLevel, String sellerRegDate, double sellerPhoneNum, double sellerStaus*/
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return new sellers(resultSet.getString("sellerId")
                                ,resultSet.getString("sellerTitle")
                                ,resultSet.getString("sellerAccount")
                                ,resultSet.getString("sellerPwd")
                                ,resultSet.getString("sellerDscp")
                                ,resultSet.getDouble("sellerLevel")
                                ,resultSet.getString("sellerRegDate")
                                ,resultSet.getDouble("sellerPhoneNum")
                                ,resultSet.getDouble("sellerStaus"));
        }
    }
}
