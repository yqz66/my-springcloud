package my.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JingCai-Java on 2018/7/23.
 */
public class Tests {
    public static void main(String[] args) {
        Arrays.asList(new Node(1, ""), new Node(1, ""));
    }

    public <T> List<List<T>> test(List<T> tList) throws Exception {
        List<T> listA = new ArrayList<T>();
        List<T> listB = new ArrayList<T>();

        for (int i = 0; i < tList.size(); i++) {
            T t1 = tList.get(i);
            T t2 = null;
            if (tList.size() <= (i + 1)) {
                t2 = tList.get(i);
            }
            // 这里判断 前面数字是否相等 4.A  4.B
            if (t1.equals(t2)) {
                //判断 T1 是A 还是 B
                if ("A".equals(t1)) {
                    listA.add(t1);
                } else {
                    listB.add(t1);
                }
                if ("B".equals(t2)) {
                    listB.add(t2);
                } else {
                    listA.add(t2);
                }
                i++;
            } else {
                if ("A".equals(t1)) {
                    listA.add(t1);
                    listB.add(null);
                } else {
                    listB.add(t1);
                    listA.add(null);
                }
            }

        }
        List<List<T>> lists = new ArrayList<>(2);
        lists.add(listA);
        lists.add(listB);
        return lists;
    }

    static class Node {
        int num;
        String str;

        public Node(int num, String str) {
            this.num = num;
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
