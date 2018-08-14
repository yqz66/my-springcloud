package my.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JingCai-Java on 2018/7/15.
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient //注册 Eureka
@EnableFeignClients(basePackages = "my.common.service") //启动 Feign
//指定微服务 DEPT-PROVIDER 使用自定义负载均衡
//@RibbonClient(value = "DEPT-PROVIDER",configuration = MyIRule.class) //启动 Ribbon
@RibbonClients
//@EnableHystrix //启动 Hystrix
@ComponentScan("my")
// 因为feign 在 my.common.service 路径下，需要配置扫描
//@ComponentScans( @ComponentScan("my.consumer"))
//@EnableHystrixDashboard // 启动hystrix 监控 访问: http://localhost:8003/hystrix  即可查看
public class MyConsumerDept8003Application {
    public static void main(String[] args) {
//         new SpringApplication(MyConsumerDept8003Application.class).run(args);
        SpringApplication.run(MyConsumerDept8003Application.class, args);
    }
}
