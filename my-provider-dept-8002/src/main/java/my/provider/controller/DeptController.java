package my.provider.controller;

import my.common.entity.Dept;
import my.provider.serivce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by JingCai-Java on 2018/6/25.
 */
@RestController
@RequestMapping(value = "dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping(value = "add")
    public int addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping(value = "list")
    public List<Dept> queryAllDept(HttpServletRequest request) {
        System.out.println("请求地址：" + request.getRequestURL().toString());
       /* try {
       // 测试 Hystrix 熔断
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return deptService.queryAllDept();
    }

    @GetMapping(value = "get/{id}")
    public Dept getDeptById(@PathVariable(value = "id") String id) {
        System.out.println("进入提供者 get/id");
        return deptService.getDeptById(id);
    }

    @GetMapping("get/host")
    public String getHost(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }
}
