package my.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by JingCai-Java on 2018/7/24.
 */
@EnableZuulProxy //启用网关代理
@SpringBootApplication
@EnableEurekaClient //注册Eureka
//@EnableDiscoveryClient
//@RibbonClients
public class MyZuulApplication {
    /**
     * zuul 默认整合了 Ribbon 和 Hystrix  如果一个请求处理超过1秒则会触发回退逻辑，可以在配置文件中修改
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MyZuulApplication.class, args);
    }
}
