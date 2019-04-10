package com.bjpowernode.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Enumeration;

/**
 * author : 动力节点
 * 2019/3/25 0025
 */
public class RequestUtil {

    /*
    *  功能：将请求协议包参数信息，赋值给对应的实体类对象
    *
    *  要求： 请求参数名称必须与实体类对象属性名【完全一致】
    */
    public static Object init(HttpServletRequest request,Class classFile){
           Object obj = null;
           Enumeration paramNames=null;
           //1.创建一个对应的实体类的对象
        try {
            obj =  classFile.newInstance();
            //2.得到当前请求协议包中所有的【参数名称】
            paramNames =request.getParameterNames();
            //3.读取请求参数并赋值
            while (paramNames.hasMoreElements()){
                String paramName =(String)paramNames.nextElement();//deptNo
                String value = request.getParameter(paramName);
                if(value!=null && !"".equals(value)){

                  Field fieldObj =  classFile.getDeclaredField(paramName);//private Integer deptNo;
                  fieldObj.setAccessible(true);
                  String typeName = fieldObj.getType().getName();
                  if("java.lang.String".equals(typeName)){
                      fieldObj.set(obj, value);
                  }else if("java.lang.Integer".equals(typeName)){
                      fieldObj.set(obj, Integer.valueOf(value));
                  }else if("java.lang.Double".equals(typeName)){
                      fieldObj.set(obj, Double.valueOf(value));
                  }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return obj;
    }
}
