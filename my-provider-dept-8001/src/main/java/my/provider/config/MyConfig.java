package my.provider.config;

import com.netflix.discovery.DiscoveryClient;
import com.sun.jersey.api.client.filter.ClientFilter;
import my.provider.filter.MyFilter;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JingCai-Java on 2018/7/30.
 */
@Configuration
public class MyConfig {

    //@Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
        DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs = new DiscoveryClient.DiscoveryClientOptionalArgs();
        ClientFilter clientFilter = new MyFilter();
        List<ClientFilter> filters = new LinkedList<>();
        filters.add(clientFilter);
        discoveryClientOptionalArgs.setAdditionalFilters(filters);
        return discoveryClientOptionalArgs;
    }
}
