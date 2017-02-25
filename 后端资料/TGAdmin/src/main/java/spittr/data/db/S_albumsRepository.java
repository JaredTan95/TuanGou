package spittr.data.db;

import spittr.data.domain.S_albums;

import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 */
public interface S_albumsRepository {

    boolean save(S_albums song);

    int count();

    S_albums findById(String id);

    List<S_albums> findSingerById(String id);

    /*ASC 、DESC*/
    List<S_albums> orderByPubTime();

    List<S_albums> findAll();

    List<S_albums> ListByVis();

    List<S_albums> findByTitle(String title);
}
