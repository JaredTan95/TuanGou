package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by tanjian on 2017/2/27.
 *
 */
@ComponentScan
@Service("ProCateService")
public class ProCateService {
    @Autowired
    private JdbcTemplate  jdbcTemplate;
    //TODO: 
}
