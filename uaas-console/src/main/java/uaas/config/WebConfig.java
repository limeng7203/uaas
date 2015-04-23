package uaas.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = "uaas")
public class WebConfig extends WebMvcConfigurerAdapter {

//	@Bean
//	@Autowired
//	public FilterRegistrationBean registration(LogUtilFilter logUtilFilter) {
//		FilterRegistrationBean registration = new FilterRegistrationBean(
//				logUtilFilter);
//		return registration;
//	}
//
//	@Bean
//	public LogUtilFilter encodingFilter() {
//		return new LogUtilFilter();
//	}
}
