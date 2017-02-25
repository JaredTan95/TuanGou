package spittr.data.db;

import spittr.data.domain.S_singer;

import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 */
public interface S_singerRepository {
    long count();

    boolean save(S_singer singer);

    S_singer findOne(long id);

    List<S_singer> findByName(String name);

    List<S_singer> findAll();
}
