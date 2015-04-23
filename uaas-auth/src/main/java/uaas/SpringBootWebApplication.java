package uaas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootWebApplication {

	private Logger log = LoggerFactory
			.getLogger(SpringBootWebApplication.class);

	public SpringBootWebApplication() {
		log.debug("自动启动metricsSpringBootWebApplication应用程序。。。");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
