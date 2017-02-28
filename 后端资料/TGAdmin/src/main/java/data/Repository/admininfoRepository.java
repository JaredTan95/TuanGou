package data.Repository;

import data.domain.admininfo;

import java.util.List;
import java.util.Map;

/**
 * Created by tanjian on 2017/2/24.
 * 定义操作管理员信息的接口类
 */
public interface admininfoRepository {

    /*保存或新增一个管理员信息*/
    boolean save(admininfo admin);

    /*更新某个管理员密码信息*/
    boolean updatePasswd(String passwd,String id);

    /*更新某个管理员密码信息*/
    boolean updateLastLoginDate(admininfo admin);

    /*
    **通过指定信息，查询某个用户信息
    **/
    admininfo  findOne(String id);

    /*
    查询所有管理员信息
    */
    List<admininfo> findAll();

    /*逐个删除管理员信息*/
    boolean delete(String id);

    public boolean validate(String name,String passwd);

    /*分页查询*/
    public List<Map<String, Object>> getPageListAllCol(String where, int currentPage, int numPerPage);
}
