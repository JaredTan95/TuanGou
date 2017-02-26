package web;

import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import data.domain.admininfo;
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
import utils.sha256;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 * Created by tanjian on 2017/2/25.
 */
@ComponentScan
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*查询一个用户的信息*/
    @RequestMapping(value = "/get/{id}",method = GET)
    public @ResponseBody admininfo get(@PathVariable("id") String id){
        return new JdbcadmininfoRepository(jdbcTemplate).findOne(id);
    }

    /*添加一个用户信息*/
    @RequestMapping(value = "/add/{account}/{passwd}",method = POST)
    public ResponseEntity<admininfo> post(@PathVariable("account") String account, @PathVariable("passwd") String pwd) throws NoSuchAlgorithmException {
        admininfo admin=new admininfo(UUIDGenerator.getUUID(),account,sha256.encrypted(pwd+sha256.encrypted(account))
                ,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));

            HttpStatus status=new JdbcadmininfoRepository(jdbcTemplate).save(admin)?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
       return new ResponseEntity<>(admin, status);
    }

    /*更新一个用户的信息*/
    @RequestMapping(value = "/update/passwd/{id}/{pwd}",method=PUT)
    public ResponseEntity<admininfo> update(@PathVariable("id") String id, @PathVariable("pwd") String pwd) throws NoSuchAlgorithmException {
        JdbcadmininfoRepository jdbcadmininfoRepository = new JdbcadmininfoRepository(jdbcTemplate);
        String passwd = pwd.trim();
        admininfo admin = jdbcadmininfoRepository.findOne(id);
        passwd = sha256.encrypted(passwd + sha256.encrypted(admin.getAdminAccount()));
        HttpStatus status = jdbcadmininfoRepository.updatePasswd(passwd, id)
                ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<admininfo>(admin, status);
    }

    /*删除一个用户信息*/
    @RequestMapping(value = "/delete/{id}",method = DELETE)
    public ResponseEntity<admininfo> delete(@PathVariable("id") String id){
        JdbcadmininfoRepository jdbcadmininfoRepository=new JdbcadmininfoRepository(jdbcTemplate);
        admininfo admin=jdbcadmininfoRepository.findOne(id);
        HttpStatus status=new JdbcadmininfoRepository(jdbcTemplate).delete(id)?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<admininfo>(admin,status);
    }
}
