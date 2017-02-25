package spittr.web;

import com.google.inject.Inject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import spittr.data.db.JdbcTemplate.JdbcAdminUserRepository;
import spittr.data.db.JdbcTemplate.JdbcS_albumsRepository;
import spittr.data.db.JdbcTemplate.JdbcS_singerRepository;
import spittr.data.db.JdbcTemplate.JdbcUsersRepository;
import spittr.data.domain.S_singer;
import spittr.data.domain.adminUser;
import spittr.utils.UUIDGenerator;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by tanjian on 2016/12/29.
 * Spittr音乐网站后台管理控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("adminId")
public class AdminController {
    private String urlPrefix="/Admin/views/";
    private JdbcOperations jdbcOperations;
    private JdbcAdminUserRepository jdbcAdminUserRepository;
    private JdbcS_singerRepository jdbcSSingerRepository;
    private JdbcUsersRepository jdbcUsersRepository;


    @Inject
    public AdminController(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
        jdbcAdminUserRepository=new JdbcAdminUserRepository(jdbcOperations);
        jdbcSSingerRepository=new JdbcS_singerRepository(jdbcOperations);
        this.jdbcUsersRepository=new JdbcUsersRepository(jdbcOperations);
    }

    @RequestMapping(value = "",method = GET)
    public String AdminIndexPage(HttpSession session){
        if(checkSession(session)){
            return urlPrefix+"index";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/login",method = GET)
    public String AdminLogin(HttpSession session){
        if(checkSession(session)){
            return "redirect:/admin";
        }else {
            return urlPrefix+"login";
        }
    }

    @RequestMapping(value = "/login/validate",method = POST)
    public @ResponseBody String validate(String adminName, String adminPwd, HttpSession session){
        String stats;
        try {
            adminUser user=jdbcAdminUserRepository.validateOne(adminName,adminPwd);
                session.setAttribute("adminId", user.getS_adminid());
                stats="true";
        }catch (Exception e){
            if((e instanceof IncorrectResultSizeDataAccessException)
                    &&((IncorrectResultSizeDataAccessException)e).getActualSize()==0){
                stats="false";
            }else {
                stats="exp";
            }
        }
        return stats;
    }

    @RequestMapping(value = "/add",method = GET)
    public @ResponseBody String addAdminUser(String name,String pwd,int authLeavel,HttpSession session){
        String stats;
        if(checkSession(session)){
            Date date=new Date();
            adminUser user=new adminUser(String.valueOf(date.getTime())
                    ,authLeavel,name
                    ,pwd,date);
            stats=jdbcAdminUserRepository.addAdminUser(user)?"true":"false";
        }else {
            return "redirect:/admin/login";
        }
        return stats;
    }

    @RequestMapping(value = "/getSingers",method = GET)
    public @ResponseBody String getSingerLists(){
        StringBuffer sb=new StringBuffer();
      /*  sb.append('[');
        for(S_singer item:jdbcSSingerRepository.findAll())
        {
            sb.append(item.toString()).append(",");
        }
        sb.append(']');*/
        return sb.toString();
    }

    @RequestMapping(value = "/countUsers",method = GET)
    public @ResponseBody String countUsers(){
        return String.valueOf(jdbcUsersRepository.count());
    }

    @RequestMapping(value = "/404",method = GET)
    public String error(){
        return urlPrefix+"404";
    }

    @RequestMapping(value = "/addSinger",method = POST)
    public @ResponseBody String addSinger(String name,String gender,String url,String descp,HttpSession session){
        String stats="false";
        if(checkSession(session)){
            if(jdbcSSingerRepository.save(new S_singer(UUIDGenerator.getUUID(),name,Integer.parseInt(gender),descp,0,url))){
                stats="true";
            }
            else {
                stats="false";
            }
        }
        return stats;
    }

    @RequestMapping(value = "/listAlbums",method = GET)
    public @ResponseBody
    List listAlbums(){
        return new JdbcS_albumsRepository(jdbcOperations).ListByVis();
    }

    private boolean checkSession(HttpSession session){
        return session.getAttribute("adminId") != null;
    }
}
