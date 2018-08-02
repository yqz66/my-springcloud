package my.provider.serivce;

import my.common.entity.Dept;

import java.util.List;

/**
 * Created by JingCai-Java on 2018/6/25.
 */

public interface DeptService {

    int addDept(Dept dept);

    List<Dept> queryAllDept();

    Dept getDeptById(String id);
}
