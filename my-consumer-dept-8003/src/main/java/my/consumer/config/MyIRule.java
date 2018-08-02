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
        int i = random.nextInt(10);
        // i 小于 3 使用第一个 否则使用第二个 (这里一共起了两个服务，可以根据自己的需求，IP 端口 之类的自己实现负载均衡)
        if (i < 3) {
            return allServers.get(0);
        }
        return allServers.get(1);
        //for (Server server : allServers) {
        //    System.out.println(server.getHostPort());
        //}
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }
}
