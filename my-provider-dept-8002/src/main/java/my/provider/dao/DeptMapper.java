package my.provider.dao;


import my.common.entity.Dept;

import java.util.List;

/**
 * Created by JingCai-Java on 2018/6/25.
 */

public interface DeptMapper {

     int addDept(Dept dept);

     List<Dept> queryAllDept();

     Dept getDeptById(String id);
}
