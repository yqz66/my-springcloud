package my.consumer.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JingCai-Java on 2018/7/15.
 */
@Configuration
public class ConfigBean {

    /**
     * 把自定义负载均衡加入容器中
     * @return
     */
    @Bean
    public IRule iRule() {
        return new MyIRule();
    }
}
