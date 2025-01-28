package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {

  // @SpringBootApplication combines 3 annotations: @Configuration, @EnableAutoConfiguration and @ComponentScan
  // This is the starting point of a Spring Boot application, for instance, you can click on the green arrow
  // next to the below line of code in IntelliJ
  
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
}
