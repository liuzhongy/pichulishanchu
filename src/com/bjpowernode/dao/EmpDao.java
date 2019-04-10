package com.bjpowernode.dao;

import com.bjpowernode.model.Emp;
import com.bjpowernode.util.SqlSession;

import java.util.List;

/**
 * author : 动力节点
 * 2019/3/23 0023
 */
public class EmpDao {

      public List findEmpAll(){
          String sql ="select * from emp";
          List list = null;
          try {
              list = SqlSession.selectList(sql, Emp.class);
          } catch (Exception e) {
              e.printStackTrace();
          }
          return list;
      }

      public Emp login(Emp emp){

             String sql ="select * from emp where empno="+emp.getEmpNo()+" and ename='"+emp.getEname()+"'";

          List list = null;
          try {
              list = SqlSession.selectList(sql, Emp.class);
          } catch (Exception e) {
              e.printStackTrace();
          }

             if(list==null || list.size()==0){
                 return null;
             }else{
                 return (Emp)list.get(0);
             }
      }

      public int  deleteEmp(String deptNo)throws Exception{
          String sql ="delete form emp where deptno="+deptNo;
          int num = SqlSession.delete(sql);
          return num;
      }
}
