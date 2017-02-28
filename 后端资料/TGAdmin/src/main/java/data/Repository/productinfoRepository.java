package data.Repository;

import data.domain.productinfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/2/25.
 */
public interface productinfoRepository {
    //插入
    boolean save(productinfo proinfo);

    /*更新某个分类信息*/
    boolean update(productinfo proinfo);

    /*
    **通过指定信息，查询某个分类信息
    **/
    productinfo  findOne(String id);

    /*
    查询所有份额里信息
    */
    List findAll();

    /*逐个删除分类信息*/
    boolean delete(String id);

    /*分页查询*/
    public List<Map<String, Object>> getPageListAllCol(String where, int currentPage, int numPerPage);
}
