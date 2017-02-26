package data.Repository.JdbcTemplate;

import data.Repository.productinfoRepository;
import data.domain.productinfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Allen on 2017/2/25.
 */
public class JdbcproductinfoRepository implements productinfoRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcproductinfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //增删改查
    private static final String INSERT_PRODUCTINFO="INSERT INTO productinfo(pro_cateId, sellerId, cateId, productId, " +
                                                    "startprice,productionDscp, salePrice, adCount, publishDate, sellCount," +
                                                    "productPic, productStatus) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_PRODUCTINFO="UPDATE productinfo set startprice=?,productionDscp=?,salePrice=?,adCount=?," +
                                                    "publishDate=?,sellCount=?,productPic=?,productStatus=?";
    private static final String FINDONE_PRODUCTINFO="SELECT pro_cateId, sellerId, cateId, productId, " +
                                                    "startprice,productionDscp, salePrice, adCount, publishDate, sellCount," +
                                                     "productPic, productStatus FROM productinfo WHERE productId=?";
    private static final String FINDALL_PRODUCTINFO="SELECT pro_cateId, sellerId, cateId, productId, " +
                                                    "startprice,productionDscp, salePrice, adCount, publishDate, sellCount," +
                                                    "productPic, productStatus FROM productinfo";
    private static final String DELETE_PRODUCTINFO="DELETE FROM productinfo WHERE productId=?";

    @Override
    public boolean save(productinfo proinfo) {
        return jdbcTemplate.update(INSERT_PRODUCTINFO,proinfo.getPro_cateId(),proinfo.getSellerId(),proinfo.getCateId(),
                proinfo.getProductId(),proinfo.getStartprice(),proinfo.getProductionDscp(),proinfo.getSalePrice(),proinfo.getAdCount(),
                proinfo.getPublishDate(),proinfo.getSellCount(),proinfo.getProductPic(),proinfo.getProductStatus())>0;
    }

    @Override
    public boolean update(productinfo proinfo) {
        return jdbcTemplate.update(UPDATE_PRODUCTINFO,proinfo.getStartprice(),proinfo.getProductionDscp(),proinfo.getSalePrice(),
                proinfo.getAdCount(),proinfo.getPublishDate(),proinfo.getSellCount(),proinfo.getProductPic(),proinfo.getProductStatus())>0;
    }

    @Override
    public productinfo findOne(String id) {
        return (productinfo) jdbcTemplate.query(FINDONE_PRODUCTINFO,new productinfoRowMapper(),id);
    }

    @Override
    public List<productinfo> findAll() {
        return jdbcTemplate.query(FINDALL_PRODUCTINFO,new productinfoRowMapper());
    }

    @Override
    public boolean delete(String id) {
        return jdbcTemplate.update(DELETE_PRODUCTINFO,id)>0;
    }
    /*String pro_cateId, String sellerId, String cateId, String productId, float startprice,
                       String productionDscp, double salePrice, double adCount, String publishDate, int sellCount,
                       String productPic, double productStatus*/
    private static final class productinfoRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return new productinfo(resultSet.getString("pro_cateId")
            ,resultSet.getString("cateId")
            ,resultSet.getString("productId")
            ,resultSet.getFloat("startprice")
            ,resultSet.getString("productionDscp")
            ,resultSet.getDouble("salePrice")
            ,resultSet.getDouble("adCount")
            ,resultSet.getString("publishDate")
            ,resultSet.getInt("sellCount")
            ,resultSet.getString("productPic")
            ,resultSet.getDouble("productStatus"));
        }
    }
}
