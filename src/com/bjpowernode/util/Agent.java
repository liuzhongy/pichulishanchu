package com.bjpowernode.util;

import com.bjpowernode.model.Dept;
import com.bjpowernode.service.DeptService;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * author : 动力节点
 * 2019/4/1 0001
 */
public class Agent implements DeptService {

    DeptService service;

    public Agent(DeptService service) {
        this.service = service;
    }

    @Override
    public int deleteDept(String deptNo) throws Exception {

        Connection con =DBUtil.getConn();
        try{
            con.setAutoCommit(false);

            this.service.deleteDept(deptNo);
            con.commit();

        }catch(Exception ex){
            ex.printStackTrace();
            con.rollback();;
        }finally{
            DBUtil.close(null);
        }
        return 0;
    }
}
