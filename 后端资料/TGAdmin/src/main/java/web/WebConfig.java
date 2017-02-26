package web;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import web.Interceptor.sessionInterceptor;
import web.Interceptor.ssoInteceptor;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
        freeMarkerConfigurer.setTemplateLoaderPath("/resources/views/freemakerTepl");
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

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ssoInteceptor()).excludePathPatterns("/login");/*除了"/login路由不会被拦截器拦截，其余均会被拦截"*/
    }

    //自定义拦截器
    @Bean
    public ssoInteceptor ssoInteceptor(){
        return new ssoInteceptor();
    }


    //自定义session拦截器,但未注册
    @Bean
    public sessionInterceptor sessionInterceptor(){
        return new sessionInterceptor();
    }


    /*Json 化*/
    @Bean
    public MappingJackson2JsonView mappingJackson2JsonView() {
        MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
        mappingJackson2JsonView.setContentType("application/json;charset=utf-8");
        return mappingJackson2JsonView;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
          StringHttpMessageConverter stringHttpMessageConverter=new StringHttpMessageConverter(Charset.forName("UTF-8"));
      stringHttpMessageConverter.setWriteAcceptCharset(false);
        List<MediaType> mediaTypes= new ArrayList<>();
        mediaTypes.add(new MediaType("text","plain", Charset.forName("UTF-8")));
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }


    //TODO:乱码问题！！！
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter=new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes= new ArrayList<>();
        mediaTypes.add(new MediaType("*","*", Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType("text","plain", Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType("application","json", Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType("text","*", Charset.forName("UTF-8")));
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        stringHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(mappingJackson2HttpMessageConverter);
        converters.add(stringHttpMessageConverter());
    }
}
