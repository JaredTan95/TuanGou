package web;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
 * Created by tanjian on 16/9/14.
 * 配置类
 */
@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/resources/views/freemakerTepl");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        return freeMarkerConfigurer;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setOrder(0);
        return freeMarkerViewResolver;
    }

    /*@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".html");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*配置C3P0数据库连接池*/
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://115.159.216.56 :3306/TGAdmin");
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


    /*Json 化*/
    @Bean
    public MappingJackson2JsonView mappingJackson2JsonView() {
        MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
        mappingJackson2JsonView.setContentType("application/json");
        return mappingJackson2JsonView;
    }
}
