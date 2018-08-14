package my.consumer.controller;

import my.common.entity.Dept;
import my.common.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by JingCai-Java on 2018/7/15.
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("get/{id}")
    public Dept getDept(@PathVariable("id") Integer id) {
        System.out.println("进入ssaf消费者 get/{id}");
        //return restTemplate.getForObject(PROVIDER_DEPT_8002_URL + "dept/get/" + id, Dept.class);
        deptService.getDept(id);
        return deptService.getDept(id);
    }

    @GetMapping("list")
    public List<Dept> queryAllDept() {
        System.out.println("进入消费者 list");
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return deptService.queryAllDept();
    }

    @GetMapping("get/host")
    public String getHost(HttpServletRequest request) {
        request.getCookies();
        System.out.println("获取地址");
        return deptService.getHost();
    }
}
