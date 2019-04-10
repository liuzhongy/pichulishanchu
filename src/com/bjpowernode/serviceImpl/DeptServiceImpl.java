package com.bjpowernode.serviceImpl;

import com.bjpowernode.dao.DeptDao;
import com.bjpowernode.dao.EmpDao;
import com.bjpowernode.service.DeptService;

/**
 * author : 动力节点
 * 2019/4/1 0001
 */
public class DeptServiceImpl implements DeptService {

    @Override
    public int deleteDept(String deptNo) throws Exception {

        DeptDao deptDao = new DeptDao();
        EmpDao empDao = new EmpDao();

        deptDao.deleteDpet(deptNo);
        empDao.deleteEmp(deptNo);
        return 0;
    }
}
