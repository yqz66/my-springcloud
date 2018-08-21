package my.consumer.aspect;

import my.common.entity.Dept;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 自定义切面，获取Controller 日志
 * Created by JingCai-Java on 2018/8/15.
 */
//声明这是一个组件
@Component
@Aspect
//声明一个切面
public class MyAspect {

    // 声明一个切入点
    @Pointcut("@annotation(my.consumer.aspect.ControllerLog)")
    public void systemControllerLog() {
    }

    //前置通知 , 在拦截方法之前执行一段逻辑 JoinPoint 通过对象可以访问链接点的细节
    @Before(value = "systemControllerLog()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();//获取参数
        System.out.println("进入前置通知参数是 ：" + args);
        joinPoint.getTarget();//目标对象
        joinPoint.getThis();// 代理本身自己对象
        joinPoint.getSignature().getDeclaringTypeName();// 目标类完全限定名
        joinPoint.getSignature().getName();//目标方法名称
        Signature signature = joinPoint.getSignature();
        try {
            //获取目标方法 1
            MethodSignature methodSignature = (MethodSignature) signature; //通过强转 可以获得Method 对象
            Method method = methodSignature.getMethod();

            //获取目标方法 2 步骤： 通过 joinPoint 代理对象获取 目标对象类型， 通过反射获取方法名称，并匹配方法参数类型，获取方法
            Method declaredMethod = joinPoint.getTarget().getClass().getDeclaredMethod(joinPoint.getSignature().getName(), ((MethodSignature) signature).getParameterTypes());
            // 方法是否相同
            System.out.println(method.equals(declaredMethod));
            //获取方法注解上的信息
            ControllerLog annotation = method.getAnnotation(ControllerLog.class);
            annotation.message();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    // 后置通知 在拦截方法执行之后执行一段逻辑   returning 获取返回值（返回值和参数类型必须一致）
    @AfterReturning(value = "systemControllerLog()", returning = "result")
    public void doAfter(JoinPoint joinPoint, List<Dept> result) {
        System.out.println("进入后置处理，list 大小: " + result.size() + "返回值是: " + result.get(result.size() - 1).getDeptName());
    }

    //异常时处理
    @AfterThrowing(value = "systemControllerLog()")
    public void doAfterThrowing() {
        System.out.println("异常处理");
    }
}
