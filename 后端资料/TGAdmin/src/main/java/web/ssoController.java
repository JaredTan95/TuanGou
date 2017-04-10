package web;

import data.domain.admininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by tanjian on 2017/2/24.
 * SSO 单点登录
 */
@ComponentScan
@Controller
@RequestMapping(value = "/sso")
public class SsoController {
    @Autowired
    private UserService userService;

  @RequestMapping(value = "/login",method = POST)
  public ResponseEntity<admininfo> login(HttpSession session, String username, String password){
      admininfo admin=new admininfo();
      admin.setAdminAccount(username);
      admin.setAdminPwd(password);
      HttpStatus status=null;
      try{
          status=userService.Validate(admin)?HttpStatus.OK:HttpStatus.NOT_FOUND;
          return new ResponseEntity<admininfo>(admin,status);
      }catch (Exception e){
          return new ResponseEntity<admininfo>(new admininfo(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

    // 退出
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            return "/login";
        } else {
            for(Cookie cookie : cookies){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    System.out.println("被删除的cookie名字为:"+cookie.getName());
                    response.addCookie(cookie);

            }
            return "/login";
        }
    }
}
