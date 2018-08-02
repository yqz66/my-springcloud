package my.zuul.config;

import my.zuul.fallback.MyFallbackProvider;
import my.zuul.filter.MyPreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JingCai-Java on 2018/7/26.
 */
@Configuration
public class MyBeanConfig {
    /***
     * 自定义 zuul 网关过滤器
     * @return
     */
    @Bean
    public MyPreFilter myPreFilter() {
        return new MyPreFilter();
    }

    /**
     * 自定义网关回退
     * @return
     */
    @Bean
    public MyFallbackProvider myFallbackProvider() {
        return new MyFallbackProvider();
    }
}
