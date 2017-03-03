package web;

import data.Repository.JdbcTemplate.JdbcorderinfoRepository;
import data.domain.orderinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.OutOrderNum;
import web.service.OrderService;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * Created by tanjian on 2017/2/26.
 * 订单操作控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderService orderService;

    /*
    * 查询一个订单
    * */
    @RequestMapping(value = "/get/{id}", method = GET)
    public ResponseEntity<orderinfo> get(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<orderinfo>(new JdbcorderinfoRepository(jdbcTemplate).findOne(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<orderinfo>(new orderinfo(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /*
    * 添加订单
    * @param pro_cateId,sellerId,cateId,ProductID,userID,OrderDate,OrderNum,OrderStatus,OrderVolume
    * */
    @RequestMapping(value = "/add", method = POST)
    public ResponseEntity<orderinfo> add(orderinfo order) {
        HttpStatus status = null;
        order.setOrderID(new OutOrderNum().OrderNum());
        JdbcorderinfoRepository jdbcorderinfoRepository = new JdbcorderinfoRepository(jdbcTemplate);
        try {
            status = jdbcorderinfoRepository.save(order) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<orderinfo>(order, status);
        } catch (Exception e) {
            return new ResponseEntity<orderinfo>(order, status);
        }
    }

    /*
    * 更新一个订单(包括更新订单状态，没有删除，只有取消订单)
    * 订单状态参数规定 ：
    *               1 ->新订单（订单默认状态）, 2 ->已取消 , 3 ->已付款 , 4 ->待发货 , 5 ->已发货 , 6 ->交易成功
    * */
    @RequestMapping(value = "/update", method = PUT)
    public ResponseEntity<orderinfo> update(orderinfo order) {
        JdbcorderinfoRepository jdbcorderinfoRepository = new JdbcorderinfoRepository(jdbcTemplate);
        HttpStatus status = null;
        try {
            status = jdbcorderinfoRepository.update(order) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<orderinfo>(order, status);
        } catch (Exception e) {
            return new ResponseEntity<orderinfo>(order, status);
        }
    }

    /*查询总记录数*/
    @RequestMapping(value = "/getTotal",method = GET)
    public @ResponseBody int getTtoal(){
        return new JdbcorderinfoRepository(jdbcTemplate).getTotal();
    }

    /*
   * 查询所有订单信息
   * */
    @RequestMapping(value = "/get/{pageSize}/{page}", method = GET)
    @ResponseBody
    public Map<String, Object> get(
            @PathVariable("pageSize") int pageSize, @PathVariable("page") int page) {
        JdbcorderinfoRepository jd = new JdbcorderinfoRepository(jdbcTemplate);
        int totalSize = jd.getTotal();
        Map<String, Object> maps = new HashMap<>();
        maps.put("total", totalSize);
        maps.put("lists", orderService.getOrderListByPage(page,pageSize));
        return maps;
    }
}
