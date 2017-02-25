package spittr.data.db;

import spittr.data.domain.S_users;

import java.util.List;

/**
 * Created by tanjian on 2016/12/30.
 */
public interface S_usersRepository {
    long count();

    boolean save(S_users user);

    S_users findOne(String id);

    S_users findByUserNickname(String username);

    List<S_users> findByNickName(String nickname);

    boolean update(S_users user);

    S_users hasOne(String account);

    List<S_users> findAll();
}
