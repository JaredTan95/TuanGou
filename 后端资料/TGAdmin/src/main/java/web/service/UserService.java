package web.service;

import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import data.domain.admininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import utils.sha256;

import java.security.NoSuchAlgorithmException;

/**
 * Created by tanjian on 2017/2/24.
 * 用户验证业务
 */
@ComponentScan
@Service("UserService")
public class UserService {

    public UserService() {
    /*    System.out.println("调用UserService");*/
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean Validate(admininfo admin) throws NoSuchAlgorithmException {
       /* sha_256(pwd原密码+sha_256(name))*/
        return new JdbcadmininfoRepository(jdbcTemplate)
                .validate(admin.getAdminAccount(),
                        sha256
                                .encrypted(admin.getAdminPwd()+sha256.encrypted(admin.getAdminAccount())));
    }
}
