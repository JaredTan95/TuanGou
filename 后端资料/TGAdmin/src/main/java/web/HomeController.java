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

    @RequestMapping(value = "",method = GET)
    public String index(){
       return "index";
    }
}
