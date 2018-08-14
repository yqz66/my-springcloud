package my.common.service.dept.callback;

import my.common.entity.Dept;
import my.common.service.dept.DeptService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JingCai-Java on 2018/7/27.
 */

/**
 * hystrix 回调类
 */
//@Service
//@Component
public class DeptCallbackServiceImpl implements DeptService {

    //FallbackFactory
    @Override
    public List<Dept> queryAllDept() {
        System.out.println("回调类 执行回退逻辑");
        List<Dept> depts = new LinkedList<>();
        Dept dept = new Dept();
        dept.setDeptId(1);
        dept.setDeptName("回调类 执行回退逻辑");
        depts.add(dept);
        return depts;
    }

    @Override
    public String getHost() {
        return "获取 host失败 回调类开始执行回退逻辑";
    }

    @Override
    public Dept getDept(Integer id) {
        return null;
    }
}
