package web.service;

import data.Repository.JdbcTemplate.JdbcorderinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tanjian on 2017/2/24.
 * 订单管理业务实现
 */
@ComponentScan
@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getOrderListByPage(int page, int pageSize){
        String sql="SELECT DISTINCT o.OrderID,p.productId,p.productName,u.userID,u.userAccount," +
                "o.OrderDate,o.OrderNum,o.OrderStatus " +
                "FROM orderinfo as o,userinfo as u,sellers as s," +
                "productinfo as p ";
        String condition="WHERE o.userID=u.userID " +
                "AND o.sellerId=s.sellerId " +
                "AND o.ProductID=p.productId";
        return  new JdbcorderinfoRepository(jdbcTemplate).getPageListAllCol(sql,condition, page, pageSize);
    }
}
