package web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by tanjian on 16/9/14.
 * 首页控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "")
public class HomeController {

    @RequestMapping(value = "", method = GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/index", method = GET)
    public String index2() {
        return "index";
    }

    @RequestMapping(value = "/login", method = GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/sign-up", method = GET)
    public String signUp() {
        return "sign-up";
    }

    @RequestMapping(value = "/404", method = GET)
    public String err404() {
        return "404";
    }

    @RequestMapping(value = "/table-list-img", method = GET)
    public String tableListImg() {
        return "table-list-img";
    }


    @RequestMapping(value = "/table-list", method = GET)
    public String tableList() {
        return "table-list";
    }


    @RequestMapping(value = "/chart", method = GET)
    public String chart() {
        return "chart";
    }


    @RequestMapping(value = "/form", method = GET)
    public String form() {
        return "form";
    }


    @RequestMapping(value = "/calendar", method = GET)
    public String calendar() {
        return "calendar";
    }


    @RequestMapping(value = "/tables", method = GET)
    public String tables() {
        return "tables";
    }

    @RequestMapping(value = "/productInfo",method = GET)
    public String productInfo(){
        return "productInfo";
    }

    @RequestMapping(value = "/orderInfo",method = GET)
    public String orderInfo(){
        return "orderInfo";
    }
}
