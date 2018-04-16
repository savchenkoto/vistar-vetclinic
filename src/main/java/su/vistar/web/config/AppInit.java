package su.vistar.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
            AppConfig.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
                AppConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
