package com.airkisser.utils.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理,能同时处理html和json格式的异常
 */
public class HandlerMethodExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(HandlerMethodExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        logger.error(e.getMessage(), e);
        ModelAndView modelAndView = null;
        HandlerMethod method = (HandlerMethod) handler;
        ResponseBody body = method.getMethodAnnotation(ResponseBody.class);
        ResponseBody classBody = method.getBean().getClass().getAnnotation(ResponseBody.class);
        if (body != null || classBody != null) {//json格式处理
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("data", null);
            map.put("message", e.getMessage());
            modelAndView = new ModelAndView(new MappingJackson2JsonView(), map);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            String message = e.getClass().getSimpleName() + "[" + e.getMessage() + "]";
            StackTraceElement[] stackTrace = e.getStackTrace();
            map.put("message", message);
            map.put("stackTrace", stackTrace);
            modelAndView = new ModelAndView("error", map);
        }
        return modelAndView;
    }
}
