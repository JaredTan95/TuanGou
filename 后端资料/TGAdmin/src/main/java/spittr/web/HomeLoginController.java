package spittr.web;

import com.google.inject.Inject;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import spittr.data.db.JdbcTemplate.JdbcSUserFavSongrepository;
import spittr.data.db.JdbcTemplate.JdbcUsersRepository;
import spittr.data.domain.S_userFavSong;
import spittr.data.domain.S_users;
import spittr.utils.UUIDGenerator;
import spittr.utils.sha256;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
/**
 * Created by tanjian on 2016/12/19.
 * 登录控制器
 */
@Controller
@RequestMapping(value = "/login")
@SessionAttributes("userId")
public class HomeLoginController {
    private String urlPrefix="/Home/views/";
    private JdbcOperations jdbcOperations;
    private JdbcUsersRepository jdbcUsersRepository;

    @Inject
    public HomeLoginController(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
        this.jdbcUsersRepository=new JdbcUsersRepository(jdbcOperations);
    }

    @RequestMapping(value = "",method = GET)
    public String loginPage(HttpSession session){
       return "login";
    }

    @RequestMapping(value = "/userisExsits",method = GET)
    @ResponseBody public boolean isExists(String account){
        return  !new JdbcUsersRepository(jdbcOperations).hasOne(account).getS_userid().equals("");
    }

    @RequestMapping(value = "/validate",method = POST)
    public @ResponseBody String validate(String uName, String uPwd, HttpSession session){
        String stats;
        try {
            S_users user =jdbcUsersRepository.validateUser(uName,sha256.encrypted(uPwd+uName));
            session.setAttribute("userId",user.getS_userid());
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

    @RequestMapping(value = "/regis",method = POST)
    public @ResponseBody boolean register(String account,String pwd,String nickname,HttpSession session){
        boolean stats;
        try {
            S_users user=new S_users(UUIDGenerator.getUUID(),account,account,sha256.encrypted(pwd+account),nickname,"","");
            if(new JdbcUsersRepository(jdbcOperations).save(user)){
                stats=true;
                session.setAttribute("userId",user.getS_userid());
            }else {
                stats=false;
            }
        } catch (Exception e) {
            stats=false;
            e.printStackTrace();
        }
        return stats;
    }

    @RequestMapping(value = "/personal",method = GET)
    public @ResponseBody String personal(HttpSession session){
        if(checkUserSession(session)){
            return urlPrefix+"personal.html";
        }
        else {
            return urlPrefix+"login.html";
        }
    }

    @RequestMapping(value = "/addToFav",method = POST)
    public @ResponseBody String addMusicToFav(String songId,HttpSession session){
        String stats;
        if(checkUserSession(session)){
            try{
                S_userFavSong sUserFavSong=new S_userFavSong(songId,session.getAttribute("userId").toString(),new Date());
                boolean saveBool=new JdbcSUserFavSongrepository(jdbcOperations).save(sUserFavSong);
                if(saveBool){
                    stats="true";
                }
                else {
                    stats="false";
                }
            }catch (Exception e){
                stats="exp"+e;
            }
        }else {
            stats="noUser";
        }
        return stats;
    }

    @RequestMapping(value = "/isAdded2Fav",method = POST)
    public @ResponseBody boolean isAdded2Fav(String songid,HttpSession session){
        if(checkUserSession(session)){
            return new JdbcSUserFavSongrepository(jdbcOperations)
                    .isExsits(new S_userFavSong(songid,session.getAttribute("userId").toString(),null));
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/personalFavMusic",method = GET)
    public @ResponseBody
    List getUserFavMusic(HttpSession session){
        if(checkUserSession(session)){
            return new JdbcSUserFavSongrepository(jdbcOperations).findUsersFav(session.getAttribute("userId").toString());
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/personalInfo",method = GET)
    public @ResponseBody
    S_users getUserInfo(HttpSession session){
        if(checkUserSession(session)){
            return new JdbcUsersRepository(jdbcOperations).findOne(session.getAttribute("userId").toString());
        }else {
            return null;
        }
    }


    private boolean checkUserSession(HttpSession session){
        return session.getAttribute("userId")!=null;
    }
}
