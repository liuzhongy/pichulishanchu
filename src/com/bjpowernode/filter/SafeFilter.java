package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SafeFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request =(HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)resp;

        //1.读取当前请求协议包中请求行url
       String uri= request.getRequestURI() ;//[/myWeb/资源路径]
        //2.判断本次请求的资源是否与登录相关，如果相关则无条件放行
        if(uri.contains("/login")){
              chain.doFilter(request, response);
        }else{//如果访问的资源与登录无关，则必须进行检查

            HttpSession session = request.getSession(false);
            if(session==null || session.getAttribute("key")==null){
                request.setAttribute("error", "恶意登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                 chain.doFilter(request, response);
            }

        }

    }


}
