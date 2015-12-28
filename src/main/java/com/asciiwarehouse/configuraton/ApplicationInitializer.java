package com.asciiwarehouse.configuraton;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

@Log4j2
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Inside ApplicationInitializer............");
        log.info("Configuring the Web Application Context..........");
        Dynamic servlet;
        try (AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext()) {
            try {
                ctx.register(CacheConfigurator.class);
                ctx.setServletContext(servletContext);
                servlet = servletContext.addServlet("rest-dispatcher", new DispatcherServlet(ctx));
            } finally {
                ctx.close();
            }
        }
        servlet.addMapping("/*");
        servlet.setLoadOnStartup(1);
    }
}