package com.syw.showmeshopsyw.util;


import com.syw.showmeshopsyw.entity.Admin;
import com.syw.showmeshopsyw.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class AdminUtil {
    private static final String adminSession ="adminSession";
    public static HttpSession getSession(){
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }
    public static void setCurrentUser(Admin current){
        if(null==current){
            getSession().invalidate();//session失效
        }else {
            getSession().setAttribute(adminSession,current);
        }
    }
    public static Admin getCurrentUser(){
        return (Admin) getSession().getAttribute(adminSession);

    }
}
