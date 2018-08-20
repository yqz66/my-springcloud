package my.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * 自定义 Ribbon 负载均衡规则实现
 * Created by JingCai-Java on 2018/7/24.
 */
public class MyIRule extends AbstractLoadBalancerRule {
    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        Random random = new Random();
        int i = random.nextInt(allServers.size());
        System.out.println("自定义负载均衡");
        // 随机返回服务
        return allServers.get(i);
        //for (Server client : allServers) {
        //    System.out.println(client.getHostPort());
        //}
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }
}
