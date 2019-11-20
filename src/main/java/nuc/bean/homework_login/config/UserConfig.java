package nuc.bean.homework_login.config;


import nuc.bean.homework_login.entity.User;
import nuc.bean.homework_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class UserConfig implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         String url ="/login";
        List<User> users = userService.getList();
        HttpSession httpSession= request.getSession(false);
        String s1 = request.getParameter("name");
        String s2 = request.getParameter("password");
        System.out.println(s1+"-----"+s2);
        if(s1 ==null || s1.equals("")){
            httpSession.setAttribute("msg1","账号不能为空");
            response.sendRedirect(url);
            return false;
        }
        if(s2.equals("")||s2==null){
            httpSession.setAttribute("msg2","密码不能为空");
            response.sendRedirect(url);
            return false;
        }
        int flage=0;
        for (User u : users) {
            if (s1.equals(u.getName()) && s2.equals(u.getPassword())) {
                    System.out.println(u.getName());
                    System.out.println(u.getPassword());
                   flage=1;
                }
            }
        if(flage==0){

            response.sendRedirect(url);

            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }




}
