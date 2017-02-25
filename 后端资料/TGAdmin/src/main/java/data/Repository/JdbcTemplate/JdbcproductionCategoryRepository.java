package data.Repository.JdbcTemplate;

import data.Repository.productCateRepository;
import data.domain.productionCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Allen on 2017/2/25.
 */
public class JdbcproductionCategoryRepository implements productCateRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcproductionCategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //增删改查
    private final static String INSERT_PRODUCTIONCATEGORY="INSERT INTO productionCategory(cateId,cateTitle) values(?,?)";
    private final static String DELETE_PRODUCTIONCATEGORY="DELETE FROM productionCategory WHERE cateId=?";
    private final static String UPDATE_PRODUCTIONCATEGORY="UPDATE productionCategory set cateTitle=?";
    private final static String FINDONE_PRODUCTIONCATEGORY="SELECT cateId,cateTitle FROM productionCategory WHERE cateId=?";
    private final static String FINDALL_PRODUCTIONCATEGORY="SELECT cateId,cateTitle FROM productionCategory";


    @Override
    public boolean save(productionCategory procate) {
        return jdbcTemplate.update(INSERT_PRODUCTIONCATEGORY,procate.getCateId(),procate.getCateTitle())>0;
    }

    @Override
    public boolean update(productionCategory procate) {
        return jdbcTemplate.update(UPDATE_PRODUCTIONCATEGORY,procate.getCateTitle())>0;
    }


    //传ID
    @Override
    public productionCategory findOne(String id) {
        return (productionCategory)jdbcTemplate.queryForObject(FINDONE_PRODUCTIONCATEGORY,new productionCategoryRowMapper(),id);
    }

    @Override
    public List<productionCategory> findAll() {
        return jdbcTemplate.query(FINDALL_PRODUCTIONCATEGORY,new productionCategoryRowMapper());
    }


    //传ID
    @Override
    public boolean delete(String id) {
        return jdbcTemplate.update(DELETE_PRODUCTIONCATEGORY,id)>0;
    }
    private final static class productionCategoryRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return new productionCategory(resultSet.getString("cateId")
                                         ,resultSet.getString("cateTitle"));
        }
    }
}
