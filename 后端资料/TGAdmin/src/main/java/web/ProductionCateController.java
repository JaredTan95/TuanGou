package web;

import data.Repository.JdbcTemplate.JdbcproductionCategoryRepository;
import data.domain.productionCategory;
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

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by tanjian on 2017/2/25.
 * 商品分类api
 */
@ComponentScan
@Controller
@RequestMapping(value = "/producCate")
public class ProductionCateController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * 查询一个商品分类信息，返回该商品信息的属性
    * */
    @RequestMapping(value = "/get/{id}",method = GET)
    public @ResponseBody productionCategory get(@PathVariable("id") String id){
        return new JdbcproductionCategoryRepository(jdbcTemplate).findOne(id);
    }


    /*
    * 新增一个商品分类
    * */
    @RequestMapping(value = "/add/{cateTitle}",method = POST)
    public ResponseEntity<productionCategory> add(@PathVariable("cateTitle") String cateTitle){
        productionCategory producCategory=new productionCategory(UUIDGenerator.getUUID(),cateTitle);
        HttpStatus status=new JdbcproductionCategoryRepository(jdbcTemplate).save(producCategory)
                ?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<productionCategory>(producCategory,status);
    }

    /*更新一个商品分类信息*/
    @RequestMapping(value = "/update/{id}/{title}",method = PUT)
    public ResponseEntity<productionCategory> update(@PathVariable("id") String id,@PathVariable("title") String title){
        productionCategory producCate=new productionCategory(id,title);
        HttpStatus status=new JdbcproductionCategoryRepository(jdbcTemplate).update(producCate)
                ?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<productionCategory>(producCate,status);
    }


    /*
    * 通过id删除一个分类信息
    * */
    @RequestMapping(value = "/delete/{id}",method = DELETE)
    public ResponseEntity<productionCategory> delete(@PathVariable("id") String id){
        JdbcproductionCategoryRepository jdbcproductionCategoryRepository=new JdbcproductionCategoryRepository(jdbcTemplate);
        productionCategory delCate=jdbcproductionCategoryRepository.findOne(id);
        HttpStatus status=jdbcproductionCategoryRepository.delete(id)
                ?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<productionCategory>(delCate,status);
    }

    /*
    * 查询所有商品分类信息
    * */
    @RequestMapping(value = "/get/{pageSize}/{page}",method = GET)
    public List<ResponseEntity<productionCategory>> get(
            @PathVariable("pageSize")String pageSize,@PathVariable("page") String page){
            //TODO:分页实现
        return null;
    }
}
