
package com.techfeel.authclient.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author bhavesh bhatt
 *
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	protected Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	    	logger.debug("WebConfig - addViewControllers- ViewControllerRegistry start");
	        registry.addViewController("/")
	                .setViewName("index");

	        registry.addViewController("/index");
	        registry.addViewController("/secure");
	    	logger.debug("WebConfig - addViewControllers- ViewControllerRegistry end");

	    }
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**")
	                .addResourceLocations("/resources/");
	    }
	    @Bean
	    public RequestContextListener requestContextListener() {
	        return new RequestContextListener();
	    }
	    @Bean
	    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }	    

}
