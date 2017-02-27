package web;

import data.domain.admininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

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
    @RequestMapping(value = "")
    public void  sso(){

    }

  /*  @RequestMapping(value = "/login",method = POST)
    public String login(HttpSession session, String username, String password)
            throws Exception {

        // 调用service进行用户身份验证
        // ...


        // 在session中保存用户身份信息
        session.setAttribute("username", username);
        // 重定向到商品列表页面
        return "redirect:/";
    }*/

  @RequestMapping(value = "/login",method = POST)
  public ResponseEntity<admininfo> login(HttpSession session, String username, String password){
      admininfo admin=new admininfo();
      admin.setAdminAccount(username);
      admin.setAdminPwd(password);
      HttpStatus status=null;
      try{
          status=userService.Validate(admin)?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
          return new ResponseEntity<admininfo>(admin,status);
      }catch (Exception e){
          return new ResponseEntity<admininfo>(new admininfo(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

    // 退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {

        // 清除session
        session.invalidate();

        // 重定向到商品列表页面
        return "redirect:/";
    }
}
