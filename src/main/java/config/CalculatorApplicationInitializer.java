package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class CalculatorApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup( ServletContext servletContext ) throws ServletException {

        System.out.println("My custom on Startup Method");
//        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//        webApplicationContext.setConfigLocation( "classpath:application-config.xml" );

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register( LoveCalculatorAppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet( webApplicationContext );
        ServletRegistration.Dynamic myServlet = servletContext.addServlet( "myDispatcherServlet",dispatcherServlet );
        myServlet.setLoadOnStartup( 1 );
        myServlet.addMapping( "/*" );

    }
}
