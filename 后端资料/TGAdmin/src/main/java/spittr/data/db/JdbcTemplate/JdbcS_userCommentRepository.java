package spittr.data.db.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.data.db.S_userCommentRepository;
import spittr.data.domain.S_userComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public class JdbcS_userCommentRepository implements S_userCommentRepository {
/*    String s_userid, String s_songid,
    String s_userCommContent, Date s_userCommDate*/
    private static final String INSERT_COMMENT="INSERT INTO S_userComment (s_userid,s_songid,s_userCommContent,s_userCommDate)" +
                                                        "VALUES (?,?,?,?);";
    private static final String SELECT_COMMENT_ABOUT_SONGID="SELECT s_userid,s_songid,s_userCommContent,s_userCommDate FROM S_userComment WHERE s_songid=?;";
    private static final String ORDER_USERCOMMENT_BY_PUBTIME="SELECT s_userid,s_songid,s_userCommContent,s_userCommDate FROM S_userComment ORDER BY s_userCommDate DESC;";

    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean save(S_userComment comment) {
        return jdbcOperations.update(INSERT_COMMENT
                                ,comment.getS_userid(),comment.getS_songid()
                                ,comment.getS_userCommContent(),comment.getS_userCommDate())>0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<S_userComment> findBySongId(String id) {
        return jdbcOperations.query(SELECT_COMMENT_ABOUT_SONGID,new S_userCommentRowMapper(),id);
    }

    @Override
    public List<S_userComment> orderUserComentByPubTime() {
        return jdbcOperations.query(ORDER_USERCOMMENT_BY_PUBTIME,new S_userCommentRowMapper());
    }

    @Override
    public List<S_userComment> findAll() {
        return null;
    }

    private static final class S_userCommentRowMapper implements RowMapper<S_userComment>{
        @Override
        public S_userComment mapRow(ResultSet resultSet, int i) throws SQLException {
            return new S_userComment(
                    resultSet.getString("s_userid")
                    ,resultSet.getString("s_songid")
                    ,resultSet.getString("s_userCommContent")
                    ,resultSet.getDate("s_userCommDate"));
        }
    }
}
