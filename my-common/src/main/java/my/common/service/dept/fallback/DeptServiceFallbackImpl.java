package my.common.service.dept.fallback;

import feign.hystrix.FallbackFactory;
import my.common.entity.Dept;
import my.common.service.dept.DeptService;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JingCai-Java on 2018/7/27.
 */
@Component
public class DeptServiceFallbackImpl implements FallbackFactory<DeptService> {

    /**
     * 出现异常时 hystrix 回退方法
     *
     * @param throwable
     * @return
     */
    @Override
    public DeptService create(Throwable throwable) {
        System.out.println("进入 hystrix 回退方法");
        throwable.printStackTrace();
        return new DeptService() {
            @Override
            public List<Dept> queryAllDept() {
                List<Dept> depts = new LinkedList<>();
                Dept dept = new Dept();
                dept.setDeptId(2);
                dept.setDeptName("调用 queryAllDept 时出现异常 , 处理完成并返回");
                depts.add(dept);
                System.out.println("进入 hystrix 回调方法，处理异常完成");
                return depts;
            }

            @Override
            public String getHost() {
                return "调用 getHost 时出现异常 , 处理完成并返回";
            }

            @Override
            public Dept getDept(Integer id) {
                Dept dept = new Dept();
                dept.setDeptId(id);
                dept.setDeptName("调用 getDept 时出现异常 , 处理完成并返回");
                return dept;
            }

        };
    }
}
