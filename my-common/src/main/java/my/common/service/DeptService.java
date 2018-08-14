package my.common.service;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import my.common.entity.Dept;
import my.common.service.fallback.DeptServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by JingCai-Java on 2018/7/24.
 * fallback = DeptCallbackServiceImpl.class
 * fallbackFactory  = DeptServiceFallback.class
 * fallback 和 fallbackFactory 任选其一。不兼容同时使用  fallbackFactory 是增强版。可以处理异常
 */
//@FeignClient(name = "${feign.name}", path = "${feign.path}",
//        /*fallback = DeptCallbackServiceImpl.class*/
//        fallbackFactory = DeptServiceFallbackImpl.class)
@FeignClient(name = "${feign.name}", path = "${feign.path}",
        /*fallback = DeptCallbackServiceImpl.class*/
        fallbackFactory = DeptServiceFallbackImpl.class)
public interface DeptService {

    @GetMapping(value = "list")
    List<Dept> queryAllDept();

    @GetMapping("get/host")
    String getHost();

    @GetMapping("get/{id}")
    Dept getDept(@CacheKey("id") @PathVariable("id") Integer id);
}
