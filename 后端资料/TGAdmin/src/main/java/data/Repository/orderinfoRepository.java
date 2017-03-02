package data.Repository;


import data.domain.orderinfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/2/25.
 */
public interface orderinfoRepository {
    //插入
    boolean save(orderinfo odinfo);

    /*更新某个订单信息*/
    boolean update(orderinfo odinfo);

    /*
    **通过指定信息，查询某个订单信息
    **/
    orderinfo  findOne(String id);

    /*
    查询所有订单信息
    */
    List findAll();

    /*逐个删除订单信息*/
    boolean delete(String id);

    /*分页查询*/
    public List<Map<String, Object>> getPageListAllCol(String where, int currentPage, int numPerPage);

    /*计算总数*/
    int getTotal();
}
