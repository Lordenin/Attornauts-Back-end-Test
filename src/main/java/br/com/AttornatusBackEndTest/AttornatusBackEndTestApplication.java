package br.com.AttornatusBackEndTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AttornatusBackEndTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AttornatusBackEndTestApplication.class, args);
	}
}
