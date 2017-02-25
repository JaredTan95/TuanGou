import Jdbc___RepositoryTest.JdbcConfig;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.domain.S_albums;
import spittr.utils.PageQueryParam;

import java.util.List;
import java.util.Map;

/**
 * Created by tanjian on 2017/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class paginationTest {
    @Autowired
    private JdbcOperations jdbcOperations;
    @Test
    public void pagination(){
        PageQueryParam param=new PageQueryParam();
        //设置每页显示多少，设置第几页
        param.setPageSize(2);
        param.setPageNumber(2);
        String SELECT_BY_VIS="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl " +
                "FROM S_albums ORDER BY s_avisRec DESC limit ?,?;";
        String sqlcount = "SELECT COUNT(*) FROM S_albums;";
        int totalCount =jdbcOperations.queryForList(sqlcount).size();
        int pageCount;
        if (totalCount % param.getPageSize() == 0) {
            pageCount = totalCount / param.getPageSize();
        } else {
            pageCount = totalCount / param.getPageSize() + 1;
        }
        Object[] object = new Object[] {  param.getIndexNum(), param.getPageSize() };

        List<S_albums> lists=jdbcOperations.query(SELECT_BY_VIS, object, (resultSet, i) -> new S_albums(
                resultSet.getString("s_aid")
                ,resultSet.getString("s_singerid")
                ,resultSet.getString("s_atitle")
                ,resultSet.getDate("s_apubTime")
                ,resultSet.getString("s_adescp")
                ,resultSet.getInt("s_avisRec")
                ,resultSet.getString("s_aCoverUrl")
        ));
        Map<Object,Object> maps=new HashedMap();
        maps.put("pageCount",pageCount);
        maps.put("albums",lists);
        List mapLists=(List) maps.get("albums");
        for(int i=0;i<mapLists.size();i++){
            System.out.println("item["+i+"]:"+mapLists.get(i).toString());
        }
    }
}
