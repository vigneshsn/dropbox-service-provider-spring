package com.vigneshsn.dropboxserviceprovider;

import com.vigneshsn.dropboxserviceprovider.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    private String TMP_FOLDER = "/tmp";
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(AppConfig.class);
        webCtx.setServletContext(servletContext);
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
        appServlet.setLoadOnStartup(1);
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
        appServlet.setMultipartConfig(multipartConfigElement);
    }
}
