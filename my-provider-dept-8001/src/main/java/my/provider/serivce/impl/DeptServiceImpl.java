package my.provider.serivce.impl;

import my.common.entity.Dept;
import my.provider.dao.DeptMapper;
import my.provider.serivce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JingCai-Java on 2018/6/25.
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public List<Dept> queryAllDept() {
        return deptMapper.queryAllDept();
    }

    @Override
    public Dept getDeptById(String id) {
        return deptMapper.getDeptById(id);
    }
}
