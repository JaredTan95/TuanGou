package spittr.data.db;

import spittr.data.domain.S_type;

import java.util.List;

/**
 * Created by tanjian on 2016/12/31.
 */
public interface S_typeRepository {
    boolean save(S_type singer);

    S_type findOne(String id);

    S_type findByUsername(String username);

    List<S_type> findAll();
}
