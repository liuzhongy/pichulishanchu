package com.bjpowernode.dao;

import com.bjpowernode.model.Dept;
import com.bjpowernode.util.SqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * author : 动力节点
 * 2019/3/23 0023
 */
public class DeptDao {


    public List findAll(){
        String sql ="select * from dept";
       List deptList = null;
        try {
            deptList=SqlSession.selectList(sql, Dept.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptList;
    }

    public int checkDname(String dname){
        String sql ="select * from dept where dname='"+dname+"'";
        List deptList = null;
        try {
            deptList=SqlSession.selectList(sql, Dept.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int result = deptList.size();
        return result;
    }

    public int deleteDpet(String deptNo)throws Exception {

        String sql ="delete from dept where deptno="+deptNo;
        int num = SqlSession.delete(sql);
        return num;
    }
}
