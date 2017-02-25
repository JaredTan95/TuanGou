package spittr.data.db.JdbcTemplate;

import com.google.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_albumsRepository;
import spittr.data.domain.S_albums;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 */
public class JdbcS_albumsRepository implements S_albumsRepository {
    private static final String INSERT_ALBUM="INSERT INTO S_albums" +
            "(s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl) VALUES (?,?,?,?,?,?,?);";
    private static final String COUNT="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums";
    private static final String SELECT_BY_ID="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums WHERE s_aid=?;";
    private static final String SELECT_BY_SINGER_ID="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums WHERE s_singerid=?;";
    private static final String ORDER_BY_PUBTIME="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums ORDER BY s_apubTime DESC;";
    private static final String SELECT_ALL="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums;";
    private static final String SELECT_BY_VIS="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums ORDER BY s_avisRec DESC;";
    private static final String SELECT_BY_TITLE_REG="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl FROM S_albums WHERE s_atitle REGEXP ?;";


    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcS_albumsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean save(S_albums album) {
        return jdbcOperations
                .update(INSERT_ALBUM
                ,album.getS_aid(),album.getS_singerid()
                ,album.getS_atitle(),album.getS_apubTime()
                ,album.getS_adescp(),album.getS_avisRec(),album.getS_aCoverUrl())>0;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForList(COUNT).size();
    }

    @Override
    public S_albums findById(String id) {
        return jdbcOperations.queryForObject(SELECT_BY_ID,new S_albumsRowMapper(),id);
    }

    @Override
    public  List<S_albums> findSingerById(String id) {
        return jdbcOperations.query(SELECT_BY_SINGER_ID,new S_albumsRowMapper(),id);
    }


    /*默认逆序排序，即————按照时间的最新情况排序*/
    @Override
    public List<S_albums> orderByPubTime() {
        return jdbcOperations.query(ORDER_BY_PUBTIME,new S_albumsRowMapper());
    }

    @Override
    public List<S_albums> findAll() {
       return jdbcOperations.query(SELECT_ALL,new S_albumsRowMapper());
    }

    @Override
    public List<S_albums> ListByVis() {
        return jdbcOperations.query(SELECT_BY_VIS,new S_albumsRowMapper());
    }

    @Override
    public List<S_albums> findByTitle(String title) {
        return jdbcOperations.query(SELECT_BY_TITLE_REG,new S_albumsRowMapper(),title);
    }

    private static final class S_albumsRowMapper implements RowMapper<S_albums> {
        @Override
        public S_albums mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_albums(
                    resultSet.getString("s_aid")
                    ,resultSet.getString("s_singerid")
                    ,resultSet.getString("s_atitle")
                    ,resultSet.getDate("s_apubTime")
                    ,resultSet.getString("s_adescp")
                    ,resultSet.getInt("s_avisRec")
                    ,resultSet.getString("s_aCoverUrl")
            );
        }
    }
}
