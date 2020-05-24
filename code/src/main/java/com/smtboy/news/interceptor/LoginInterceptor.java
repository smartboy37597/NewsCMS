package com.smtboy.news.interceptor;


import com.smtboy.news.common.Const;
import com.smtboy.news.vo.UserLoginVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //返回值true：请求会被继续运行
    //返回值false:请求将被停止
    //Object o 被拦截的请求的目标对象（控制器中的名称）
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        UserLoginVo userLoginVo = (UserLoginVo)httpServletRequest.getSession().getAttribute(Const.CURRENT_USER);
        if (userLoginVo==null){
            httpServletResponse.sendRedirect(Const.REQUEST_PREFIX+"/user/checkLogin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
