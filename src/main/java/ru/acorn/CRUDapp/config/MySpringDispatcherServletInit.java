package ru.acorn.CRUDapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringDispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {        //путь к конфигу
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {               // все запросы идут на сервлет {"/"}
        return new String[] {"/"};
    }
}
