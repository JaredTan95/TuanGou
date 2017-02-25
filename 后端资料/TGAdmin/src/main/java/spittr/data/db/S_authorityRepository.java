package spittr.data.db;

import spittr.data.domain.S_authority;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_authorityRepository {
    boolean save(S_authority sAuthority);

    List<S_authority> findById(String id);

    List<S_authority> findByOperator(String OperatorId);
}
