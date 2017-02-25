package data.Repository;

import data.domain.productionCategory;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/2/25.
 */
public interface productCateRepository {
    /*保存或新增一个分类信息*/
    boolean save(productionCategory procate);

    /*更新某个分类信息*/
    boolean update(productionCategory procate);

    /*
    **通过指定信息，查询某个分类信息
    **/
    productionCategory  findOne(String id);

    /*
    查询所有份额里信息
    */
    List<productionCategory> findAll();

    /*逐个删除分类信息*/
    boolean delete(String id);
}
