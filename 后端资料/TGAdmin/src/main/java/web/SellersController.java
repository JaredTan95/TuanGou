package web;

import data.Repository.JdbcTemplate.JdbcsellerRepository;
import data.domain.sellers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.UUIDGenerator;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by tanjian on 2017/2/25.
 * 对商家信息进行操作API
 */
@ComponentScan
@Controller
@RequestMapping(value = "/seller")
public class SellersController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    *查询一个商家信息
    * */
    @RequestMapping(value = "/get/{id}", method = GET)
    public ResponseEntity<sellers> get(@PathVariable("id") String id) {
        sellers seller;
        try {
            seller = new JdbcsellerRepository(jdbcTemplate).findOne(id);
            return new ResponseEntity<sellers>(seller, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<sellers>(new sellers(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    * 添加一个商家信息
    * 参数体：x-www-form-urlencoded
    * 参数：sellers对象的属性
    * */
    @RequestMapping(value = "/add", method = POST)
   /* public @ResponseBody sellers add(String title, String account, String pwd
            , String dscp, int level, Date date,String phone,int status){*/
    public ResponseEntity<sellers> add(sellers seller) {
        seller.setSellerId(UUIDGenerator.getUUID());
        JdbcsellerRepository jdbcsellerRepository = new JdbcsellerRepository(jdbcTemplate);
        HttpStatus status = jdbcsellerRepository.save(seller) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<sellers>(seller, status);
    }

    /*
    * 更新一个商家信息
    * */
    @RequestMapping(value = "/update", method = PUT)
    public ResponseEntity<sellers> update(sellers seller) {
        HttpStatus status = new JdbcsellerRepository(jdbcTemplate).update(seller)
                ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<sellers>(seller, HttpStatus.OK);
    }

    /*
    * 删除一个商家信息
    * */
    @RequestMapping(value = "/delete/{id}", method = DELETE)
    public ResponseEntity<sellers> delete(@PathVariable("id") String id) {
        JdbcsellerRepository jdbcsellerRepository = new JdbcsellerRepository(jdbcTemplate);
        sellers seller = jdbcsellerRepository.findOne(id);
        HttpStatus status = jdbcsellerRepository.delete(id) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<sellers>(seller, status);
    }

    /*查询总记录数*/
    @RequestMapping(value = "/getTotal", method = GET)
    public
    @ResponseBody
    int getTtoal() {
        return new JdbcsellerRepository(jdbcTemplate).getTotal();
    }


    /*
    * 查询所有商家信息
    * */
    @RequestMapping(value = "/get/{pageSize}/{page}", method = GET)
    @ResponseBody
    public Map<String, Object> get(
            @PathVariable("pageSize") int pageSize, @PathVariable("page") int page) {
        JdbcsellerRepository jd = new JdbcsellerRepository(jdbcTemplate);
        int totalSize = jd.getTotal();
        Map<String, Object> maps = new HashMap<>();
        maps.put("total", totalSize);
        maps.put("lists", jd.getPageListAllCol("",page,pageSize));
        return maps;
    }

}
