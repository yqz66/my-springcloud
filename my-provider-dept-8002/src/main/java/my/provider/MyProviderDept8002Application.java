package my.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "my.provider.dao")
@EnableEurekaClient //服务注册
//@EnableDiscoveryClient
public class MyProviderDept8002Application {

	public static void main(String[] args) {
		SpringApplication.run(MyProviderDept8002Application.class, args);
	}
}
