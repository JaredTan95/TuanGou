package Jdbc___RepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.data.db.JdbcTemplate.JdbcS_singerRepository;
import spittr.data.domain.S_singer;
import spittr.utils.UUIDGenerator;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tanjian on 2016/12/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcS_singersRepositoryTest {
    private static S_singer[] SINGERS = new S_singer[10];

    @Autowired
    private JdbcS_singerRepository jdbcSSingerRepository;

    @Test
    public void count(){
        if(jdbcSSingerRepository!=null){
           System.out.println("Singer Count:"+jdbcSSingerRepository.count());
        }
    }


    //@Test
    public void save(){
        assertEquals(true, jdbcSSingerRepository
                .save(new S_singer(UUIDGenerator.getUUID(),"test",'3'
                        ,"X-Ray Dog是一个专门为好莱坞电影预告配乐的音乐工作室。" +
                        "他们的作品几乎不针对一般消费者，网上也很少或者几乎没有他们的配乐作品下载。" +
                        "他们的作品对口直接输送到了数字影视后期制作公司。约六成以上的好莱坞强片的预告片配乐都出自他们名下！" +
                        "像是神鬼奇航系列、魔戒系列、黄金罗盘、那尼亚传奇、金刚、X-man系列、变形金刚、凡赫辛等等，" +
                        "只要是气势磅礴的动作片、史诗巨片几乎都是一致选用口碑甚佳的X-Ray Dog！",23,"123.207.83.185/SpittrResources/MusicLibs/musicCover/X-Ray-Dog.jpg")));
    }

    @Test
    public void findAll(){
        List lists=jdbcSSingerRepository.findAll();
        for(int i=0;i<lists.size();i++){
            SINGERS[i]= (S_singer) lists.get(i);
        }
        for(int i=0;i<lists.size();i++){
            System.out.println(SINGERS[i].toString());
        }
    }

    @Test
    public void findById(){
        System.out.println("findOne:"+jdbcSSingerRepository.findOne(201629739).toString());
    }

    @Test
    public void findByName(){
        System.out.println("findByName:"+jdbcSSingerRepository.findByName("Two Steps From Hell").toString());
    }

    private static void assertS_singer(int expectedS_singerIndex,
                                       S_singer actual,String expectedStatus ){
        S_singer expected = SINGERS[expectedS_singerIndex];
        assertEquals(expected.getS_singerid(),actual.getS_singerid());
    }
}
