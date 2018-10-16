package nl.blogspot.javasolutionsguide.springToolSuiteProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringToolSuiteProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringToolSuiteProjectApplication.class, args);
	}
}
