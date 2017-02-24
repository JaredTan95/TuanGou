package data.Repository;

import data.domain.admininfo;

import java.util.List;

/**
 * Created by tanjian on 2017/2/24.
 * 定义操作管理员信息的接口类
 */
public interface admininfoRepository {

    /*保存或新增一个管理员信息*/
    boolean save(admininfo admin);

    /*更新某个管理员信息*/
    boolean update(admininfo admin);

    /*
    **通过指定信息，查询某个用户信息
    **/
    admininfo  findOne(admininfo admin);

    /*
    查询所有管理员信息
    */
    List<admininfo> findAll();

    /*逐个删除管理员信息*/
    boolean delete(admininfo admin);
}
