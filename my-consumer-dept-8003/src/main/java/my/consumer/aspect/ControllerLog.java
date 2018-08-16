package my.consumer.aspect;

import java.lang.annotation.*;

/**
 * Created by JingCai-Java on 2018/8/15.
 */
@Retention(RetentionPolicy.RUNTIME) //注解运行时能生效
@Target(ElementType.METHOD) //目标作用在方法上
@Documented
public @interface ControllerLog {
    String message() default "";
}
