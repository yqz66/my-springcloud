package my.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * Created by JingCai-Java on 2018/7/15.
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient //注册 Eureka
@EnableFeignClients //启动 Feign
@RibbonClients //启动 Ribbon
@EnableHystrix //启动 Hystrix
@EnableHystrixDashboard // 启动hystrix 监控 访问: http://localhost:8003/hystrix  即可查看
public class MyConsumerDept8003Application {
    public static void main(String[] args) {
//         new SpringApplication(MyConsumerDept8003Application.class).run(args);
        SpringApplication.run(MyConsumerDept8003Application.class,args);
    }
}
