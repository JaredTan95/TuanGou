package spittr.data.db;

import spittr.data.domain.S_song;

import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 */
public interface S_songRepository {
    int count();

    boolean save(S_song song);

    S_song findBySongId(String id);

    S_song findBySingerId(String id);

    List<S_song> findAll();

    List<S_song> listByVisitedNum();

    List<S_song> findByTitle(String title);

    boolean addVisitedNUm(String id);
}
