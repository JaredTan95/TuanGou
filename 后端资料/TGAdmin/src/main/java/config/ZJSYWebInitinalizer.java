package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by tanjian on 16/9/14.
 *
 */
public class ZJSYWebInitinalizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{web.WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
