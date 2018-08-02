package my.provider;

import java.util.LinkedList;

/**
 * Created by JingCai-Java on 2018/7/23.
 */
public class Tests {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(null);
        list.add(null);
        for (String s : list ){
            System.out.println(s);
        }

    }
}
