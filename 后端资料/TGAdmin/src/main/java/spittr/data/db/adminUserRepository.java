package spittr.data.db;

import spittr.data.domain.adminUser;

import java.util.List;

/**
 * Created by tanjian on 2016/12/29.
 */
public interface adminUserRepository {
    long count();

    adminUser save(adminUser adminuser);

    adminUser findOne(long id);

    adminUser findByUsername(String username);

    List<adminUser> findAll();
}
