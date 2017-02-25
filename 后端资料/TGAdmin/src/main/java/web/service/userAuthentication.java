package web.service;

import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by tanjian on 2017/2/24.
 * 用户验证业务
 */
public class userAuthentication {

    private JdbcTemplate jdbcTemplate;

    public userAuthentication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List checkLogin(){
        return new JdbcadmininfoRepository(jdbcTemplate).findAll();
    }
}
