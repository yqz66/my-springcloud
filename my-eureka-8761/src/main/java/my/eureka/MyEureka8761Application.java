package my.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //标名自己是一个 Eureka Server
public class MyEureka8761Application {

	public static void main(String[] args) {
		//SpringApplication.run(MyEureak8761Application.class, args);
		new SpringApplication(MyEureka8761Application.class).run(args);
	}
}