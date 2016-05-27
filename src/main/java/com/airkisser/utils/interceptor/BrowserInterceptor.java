package com.airkisser.utils.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BrowserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String agent = request.getHeader("User-Agent").toLowerCase();
        if (request.getHeader("User-Agent") != null) {
            boolean flag = false;
            if (agent.indexOf("msie 6") > 0) {
                flag = true;
            } else if (agent.indexOf("msie 7") > 0) {
                flag = true;
            } else if (agent.indexOf("msie 8") > 0) {
                flag = true;
            }
            if (flag) {
                request.getRequestDispatcher("/browser_error.jsp").forward(request, response);
                return false;
            }
        }
        return true;
    }
}
