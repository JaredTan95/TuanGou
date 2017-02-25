import com.mchange.v2.c3p0.ComboPooledDataSource;
import data.Repository.JdbcTemplate.JdbcadmininfoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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
    ds.setJdbcUrl("jdbc:mysql://115.159.216.56:3306/TGAdmin");
    ds.setUser("dev");
    ds.setPassword("123456");
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
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
    public JdbcadmininfoRepository jdbcadmininfoRepository(JdbcTemplate jdbcTemplate){
      return new JdbcadmininfoRepository(jdbcTemplate);
  }
}
