package spittr.data.db;

import spittr.data.domain.S_listendRec;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_uListendRecRepository {
    boolean seva(S_listendRec sListendRec);

    List<S_listendRec> findByUserId(String id);
}
