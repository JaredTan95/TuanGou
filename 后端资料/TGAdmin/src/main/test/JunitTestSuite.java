import Jdbc___RepositoryTest.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by tanjian on 2016/12/31.
 * Junit单元测试套件测试
 */
/*
     * 1.测试套件就是组织测试类一起运行的
     *
     * 写一个作为测试套件的入口类，这个类里不包含其他的方法
     * 更改测试运行器Suite.class
     * 将要测试的类作为数组传入到Suite.SuiteClasses（{}）
*/

@RunWith(Suite.class)
@Suite.SuiteClasses({JdbcS_typeRepositoryTest.class, JdbcS_singersRepositoryTest.class
                    , JdbcS_songRepositoryTest.class, JdbcS_albumsRepositoryTest.class
                    , JdbcS_uFavAlbumRepositoryTest.class,JdbcS_userCommentRepositoryTest.class
                    ,JdbcS_MusicAlbumRelRepositoryTest.class,JdbcS_uListendRecRepositoryTest.class
                    ,JdbcS_authorityRepositorytest.class,JdbcS_MusicCategpryRepositoryTest.class
                    ,Jdbc_userRepositoryTest.class
                    ,sha256Test.class})
public class JunitTestSuite {

}  