package data.Repository;

import data.domain.sellers;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/2/25.
 */
public interface sellerRepository {
    /*插入一个商家*/
    boolean save(sellers ser);

    /*修改商家密码*/
    boolean updatePasswd(sellers ser);

    /*修改商家信息*/
    boolean update(sellers ser);

    /*查询某个商家信息*/
    sellers findOne(String id);

    /*查询所有商家信息*/
    List<sellers> findAll();

    /*删除商家信息*/
    boolean delete(String id);


    /* 分页查询*/
    public List<Map<String, Object>> getPageListAllCol(String where, int currentPage, int numPerPage);
}
