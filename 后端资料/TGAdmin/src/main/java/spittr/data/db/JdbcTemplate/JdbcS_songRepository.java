package spittr.data.db.JdbcTemplate;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_songRepository;
import spittr.data.domain.S_song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 * 基于JdbcTemplate的 S_song音乐类型的增删查改
 */
public class JdbcS_songRepository implements S_songRepository {
    private static final String COUNT_SONG="SELECT s_songid FROM S_song;";
    private static final String SELECT_ALL_SONGS="SELECT * FROM S_song;";
    private static final String SELECT_BY_ID="SELECT * FROM S_song WHERE s_songid=?;";
    private static final String SELECT_BY_SINGER_ID="SELECT * FROM S_song WHERE s_singerid=?;";
    private static final String SELECT_BY_TITLE_REG="SELECT s_songid,s_singerid,s_title,s_surl,s_visited,s_visitedTotal,s_dloaded,s_scover,s_smvurl,s_songdescp FROM S_song WHERE s_title REGEXP ?;";
    private static final String INSERT_SONG="INSERT INTO S_song" +
            "(s_songid,s_singerid,s_title,s_surl,s_visited,s_visitedTotal" +
            ",s_dloaded,s_scover,s_smvurl,s_songdescp)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String QUERY_BY_VISITEDNUM="SELECT s_songid,s_singerid,s_title,s_surl,s_visited," +
                                                     "s_visitedTotal,s_dloaded,s_scover,s_smvurl,s_songdescp" +
                                                    " FROM S_song ORDER BY s_visitedTotal DESC LIMIT 8;";
    private static final String ADD_UP_VISITEDNUM="UPDATE S_song SET s_visited=s_visited+1," +
                                                    " s_visitedTotal=s_visitedTotal+1 WHERE s_songid=?;";

    private JdbcOperations jdbcOperations;

    public JdbcS_songRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForList(COUNT_SONG).size();
    }

    @Override
    public boolean save(S_song song) {
        return jdbcOperations
                .update(INSERT_SONG
                       ,song.getS_songid(),song.getS_singerid()
                       ,song.getS_title(),song.getS_surl()
                       ,song.getS_visited(),song.getS_visitedTotal()
                       ,song.getS_dloaded(),song.getS_scover()
                       ,song.getS_smvurl(),song.getS_songdescp())>0;
    }

    @Override
    public S_song findBySongId(String id) {
        return  jdbcOperations.queryForObject(SELECT_BY_ID,new S_songRowMapper(),id);
    }

    @Override
    public S_song findBySingerId(String id) {
        return jdbcOperations.queryForObject(SELECT_BY_SINGER_ID,new S_songRowMapper(),id);
    }


    @Override
    public List<S_song> findAll() {
       return jdbcOperations.query(SELECT_ALL_SONGS,new S_songRowMapper());
    }

    @Override
    public List<S_song> listByVisitedNum() {
        return jdbcOperations.query(QUERY_BY_VISITEDNUM,new S_songRowMapper());
    }

    @Override
    public List<S_song> findByTitle(String title) {
        return jdbcOperations.query(SELECT_BY_TITLE_REG,new S_songRowMapper(),title);
    }

    @Override
    public boolean addVisitedNUm(String id) {
        return jdbcOperations.update(ADD_UP_VISITEDNUM,id)>0;
    }

    private static final class S_songRowMapper implements RowMapper<S_song> {
        @Override
        public S_song mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_song(
                    resultSet.getString("s_songid")
                    , resultSet.getString("s_singerid")
                    , resultSet.getString("s_title")
                    , resultSet.getString("s_surl")
                    ,resultSet.getInt("s_visited")
                    ,resultSet.getInt("s_visitedTotal")
                    ,resultSet.getInt("s_dloaded")
                    ,resultSet.getString("s_scover")
                    ,resultSet.getString("s_smvurl")
                    ,resultSet.getString("s_songdescp")
            );
        }
    }
}
