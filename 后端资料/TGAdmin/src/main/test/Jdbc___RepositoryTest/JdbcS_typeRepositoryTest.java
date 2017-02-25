package Jdbc___RepositoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_typeRepository;
import spittr.data.domain.S_type;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tanjian on 2016/12/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_typeRepositoryTest {

    @Autowired
    private JdbcS_typeRepository jdbcSTypeRepository;

    //@Test
    public void save(){
        assertEquals(true,jdbcSTypeRepository.save(new S_type("182374","soft music")));
    }

    @Test
    public void findAll(){
        List lists=jdbcSTypeRepository.findAll();
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
    }

    @Test
    public void findById(){
        assertEquals("electronic music",jdbcSTypeRepository.findOne("2341").getS_sttitle());
    }
}
