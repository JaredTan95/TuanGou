package Jdbc___RepositoryTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import spittr.data.db.JdbcTemplate.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class JdbcConfig {
  /*@Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScripts("classpath:spittr/db/jdbc/schema.sql", "classpath:spittr/db/jdbc/test-data.sql")
      .build();
  }*/

  /*配置C3P0数据库连接池*/
  @Bean
  public ComboPooledDataSource dataSource() throws PropertyVetoException {
    ComboPooledDataSource ds=new ComboPooledDataSource();
    ds.setDriverClass("com.mysql.jdbc.Driver");
    ds.setJdbcUrl("jdbc:mysql://123.207.83.185:3306/Spittr");
    ds.setUser("tanjian");
    ds.setPassword("tanjianOnSpittr");
    ds.setInitialPoolSize(5);
    ds.setMaxPoolSize(10);
    ds.setMinPoolSize(3);
    ds.setMaxIdleTime(600);
    return ds;
  }
  
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public JdbcUsersRepository jdbcUsersRepository(JdbcTemplate jdbcTemplate){
    return new JdbcUsersRepository(jdbcTemplate);
  }
  @Bean
  public JdbcS_singerRepository jdbcSSingerRepository(JdbcTemplate jdbcTemplate) {
    return new JdbcS_singerRepository(jdbcTemplate);
  }

  @Bean
  public JdbcS_typeRepository jdbcSTypeRepository(){
      return new JdbcS_typeRepository();
  }

  @Bean
  public JdbcS_songRepository jdbcSSongRepository(JdbcTemplate jdbcTemplate){
      return new JdbcS_songRepository(jdbcTemplate);
  }


  @Bean
  public JdbcSUserFavSongrepository jdbcSUserFavSongrepository(JdbcTemplate jdbcTemplate){
      return new JdbcSUserFavSongrepository(jdbcTemplate);
  }

  @Bean
  public JdbcS_userFavAlbumRepository jdbcSUserFavAlbumRepository(){
      return new JdbcS_userFavAlbumRepository();
  }

  @Bean
  public JdbcS_userCommentRepository jdbcSUserCommentRepository(){
      return new JdbcS_userCommentRepository();
  }

  @Bean
  public JdbcS_MusicAlbumRelRepository jdbcSMusicAlbumRelRepository(JdbcTemplate jdbcTemplate){
      return new JdbcS_MusicAlbumRelRepository(jdbcTemplate);
  }

  @Bean
  public JdbcS_uListendRecRepository jdbcSUListendRecRepository(){
    return new JdbcS_uListendRecRepository();
  }

  @Bean
  public JdbcS_authorityRepository jdbcSAuthorityRepository(){
    return new JdbcS_authorityRepository();
  }
  @Bean
  public JdbcS_MusicCategoryRepository jdbcSMusicCategoryRepository(){
    return new JdbcS_MusicCategoryRepository();
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }


  @Bean
  public JdbcS_albumsRepository jdbcSAlbumsRepository(JdbcTemplate jdbcTemplate){
    return new JdbcS_albumsRepository(jdbcTemplate);
  }

}
