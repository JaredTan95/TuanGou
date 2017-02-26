package data.Repository.JdbcTemplate;

import data.Repository.orderinfoRepository;
import data.domain.orderinfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Allen on 2017/2/25.
 */
public class JdbcorderinfoRepository implements orderinfoRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcorderinfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_ORDERINFO="INSERT INTO orderinfo(orderID, pro_cateId, sellerId, cateId, productID," +
            "userID, orderDate, orderNum, orderStatus, orderVolume) values(?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_ORDERINFO="UPDATE orderinfo SET pro_cateId=?,sellerId=?,cateId=?,productID=?," +
            "userID=?,orderDate=?,orderNum=?,orderStatus=?,orderVolume=?";
    private static final String FINDONE_ORDERINFO="SELECT OrderID, pro_cateId, sellerId, cateId, ProductID," +
            "userID, OrderDate, OrderNum, OrderStatus, OrderVolume FROM orderinfo WHERE OrderID=?";
    private static final String FINDALL_ORDERINFO="SELECT orderID, pro_cateId, sellerId, cateId, productID," +
            "userID, orderDate, orderNum, orderStatus, orderVolume FROM orderinfo";
    private static final String DELETE_ORDERINFO="DELETE FROM orderinfo WHERE orderID=?";

    @Override
    public boolean save(orderinfo odinfo) {
        return jdbcTemplate.update(INSERT_ORDERINFO,odinfo.getOrderID(),odinfo.getPro_cateId(),odinfo.getSellerId(),
                odinfo.getCateId(),odinfo.getProductID(),odinfo.getUserID(),odinfo.getOrderDate(),odinfo.getOrderNum(),
                odinfo.getOrderStatus(),odinfo.getOrderVolume())>0;
    }

    @Override
    public boolean update(orderinfo odinfo) {
        return jdbcTemplate.update(UPDATE_ORDERINFO,odinfo.getPro_cateId(),odinfo.getSellerId(),
                odinfo.getCateId(),odinfo.getProductID(),odinfo.getUserID(),odinfo.getOrderDate(),odinfo.getOrderNum(),
                odinfo.getOrderStatus(),odinfo.getOrderVolume())>0;
    }

    @Override
    public orderinfo findOne(String id) {
        return (orderinfo) jdbcTemplate.queryForObject(FINDONE_ORDERINFO,new orderinfoRowMapper(),id);
    }

    @Override
    public List<orderinfo> findAll() {
        return jdbcTemplate.query(FINDALL_ORDERINFO,new orderinfoRowMapper());
    }

    @Override
    public boolean delete(String id) {
        return jdbcTemplate.update(DELETE_ORDERINFO,id)>0;
    }

    private static final class orderinfoRowMapper implements RowMapper{
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return new orderinfo(resultSet.getString("orderID")
            ,resultSet.getString("pro_cateId")
            ,resultSet.getString("sellerId")
            ,resultSet.getString("cateId")
            ,resultSet.getString("productID")
            ,resultSet.getString("userID")
            ,resultSet.getDate("orderDate")
            ,resultSet.getInt("orderNum")
            ,resultSet.getInt("orderStatus")
            ,resultSet.getInt("orderVolume"));
        }
    }
}
