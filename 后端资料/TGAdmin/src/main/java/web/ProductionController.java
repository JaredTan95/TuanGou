package web;

import data.Repository.JdbcTemplate.JdbcproductinfoRepository;
import data.domain.productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by tanjian on 2017/2/26.
 * 商品信息操作控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "/production")
public class ProductionController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * 查询一个商品详情
    * */
    @RequestMapping(value = "/get/{id}",method = GET)
    public ResponseEntity<productinfo> get(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(new JdbcproductinfoRepository(jdbcTemplate).findOne(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new productinfo(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    * 更新一个商品信息(包括更新商品状态)
    * */
    @RequestMapping(value = "/update",method = PUT)
    public ResponseEntity<productinfo> update(productinfo product){
        HttpStatus status=null;
        try {
            status=new JdbcproductinfoRepository(jdbcTemplate).update(product)?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(product, status);
        }catch (Exception e){
            status=HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(product, status);
        }
    }

    /*
    * 添加一件商品
    * */
    @RequestMapping(value = "/add",method = POST)
    public ResponseEntity<productinfo> add(productinfo product){
        HttpStatus status=null;
        try {
            status=new JdbcproductinfoRepository(jdbcTemplate).save(product)?HttpStatus.OK:HttpStatus.EXPECTATION_FAILED;
            return new ResponseEntity<>(product, status);
        }catch (Exception e){
            status=HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(product, status);
        }
    }

    /*
    * 删除一件商品(商品不能删除，只能修改商品的状态码)
    * 商品状态参数:
    *           1 ->新增（待审核）商品（数据库默认状态） , 2 ->已审核或已上架 , 3 -> 已下架
    * 参照上面update（）方法;
    * */




    /*查询总记录数*/
    @RequestMapping(value = "/getTotal",method = GET)
    public @ResponseBody
    int getTtoal(){
        return new JdbcproductinfoRepository(jdbcTemplate).getTotal();
    }


    /*分页查询商品*/
    /*
   * 查询所有订单信息
   * */
    @RequestMapping(value = "/get/{pageSize}/{page}", method = GET)
    @ResponseBody
    public Map<String, Object> get(
            @PathVariable("pageSize") int pageSize, @PathVariable("page") int page) {
        JdbcproductinfoRepository jd = new JdbcproductinfoRepository(jdbcTemplate);
        int totalSize = jd.getTotal();
        Map<String, Object> maps = new HashMap<>();
        maps.put("total", totalSize);
        maps.put("lists", jd.getPageListAllCol("",page,pageSize));
        return maps;
    }





    //TODO:图片上传
    /*处理图片上传*/
    @RequestMapping(value = "/upload",method = POST)
    public ResponseEntity processUploadFile(@RequestPart(value = "file", required = true) Part file) throws IOException {
        String path="/resources/UploadImg/";
        String fileName="dfdsfserrrrrr.jgp";
        //保存
        try {
            file.write(path+fileName);
            return new ResponseEntity(path+fileName ,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(path+fileName ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
