import data.domain.admininfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.WebConfig;
import web.service.UserService;

/**
 * Created by tanjian on 2017/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
public class testService {
    @Autowired
    private UserService userService;
    @Test
    public void tetsServive(){
        admininfo admin=new admininfo();
        admin.setAdminId("8502761f07ef4c06a58e1bc85064ffb4");
    }
}
