package my.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by JingCai-Java on 2018/8/2.
 */
@SpringBootApplication
@EnableConfigServer //声明一个配置中心服务
@EnableEurekaClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        new SpringApplication(ConfigServerApplication.class).run(args);
    }
}