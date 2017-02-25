package spittr.data.db;

import spittr.data.domain.S_userComment;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_userCommentRepository {
    boolean save(S_userComment comment);


    int count();

    List<S_userComment> findBySongId(String id);

    /*ASC 、DESC*/
    List<S_userComment> orderUserComentByPubTime();

    List<S_userComment> findAll();
}
