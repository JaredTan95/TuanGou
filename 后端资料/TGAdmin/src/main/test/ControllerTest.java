import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.web.servlet.MockMvc;
import spittr.web.HomeController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by tanjian on 2017/1/21.
 */
public class ControllerTest {
    @Autowired
    private JdbcOperations jdbcOperations;
    @Test
    public void index() throws Exception {
        HomeController homeController=new HomeController(jdbcOperations);
        MockMvc mockMvc=standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("/Home/views/index"));
    }

    @Test
    public void ttt() throws Exception {
        HomeController homeController=new HomeController(jdbcOperations);
        MockMvc mockMvc=standaloneSetup(homeController).build();
        mockMvc.perform(get("/ttt")).andExpect(view().name("test"));
    }
}
