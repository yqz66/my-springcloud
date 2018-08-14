package my.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by JingCai-Java on 2018/7/31.
 */
@SpringBootApplication
@EnableEurekaClient
public class MyConfigApplication {
    public static void main(String[] args) {
        new SpringApplication(MyConfigApplication.class).run(args);
    }
}
