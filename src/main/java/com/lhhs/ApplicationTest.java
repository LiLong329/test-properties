package com.lhhs;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({"com.lhhs"})
@ServletComponentScan
public class ApplicationTest extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger logger = Logger.getLogger(ApplicationTest.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationTest.class, args);
	}
	
    @Override
	public void run(String... arg0) throws Exception {

		logger.info(""+
				"         .   ____          _            __ _ _\n" + 
				" /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n" + 
				"( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n" + 
				" \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n" + 
				"  '  |____| .__|_| |_|_| |_\\__, | / / / /\n" + 
				" =========|_|==============|___/=/_/_/_/ 		  ");
		
		logger.info(" :: Spring Boot ::  启动完成");
		
	}

}
