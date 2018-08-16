package my.provider;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by JingCai-Java on 2018/7/23.
 */
public class Tests {
    public void test (String strings){
        System.out.println(strings);
    }
    public static void main(String[] args) {
        try {
            Method test = Tests.class.getMethod("test", String.class);
            try {
                test.invoke(Tests.class.newInstance(), "执行");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
