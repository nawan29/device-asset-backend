package com.example.deviceassetsystem.config;

import com.example.deviceassetsystem.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 如果是预检请求（OPTIONS），直接放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 2. 如果是登录接口，不需要拦截，直接放行
        if ("/api/login".equals(request.getRequestURI())) {
            return true;
        }

        // 3. 获取前端传过来的 Token
        String token = request.getHeader("Authorization");

        // 4. 没带 Token 直接拦截
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }

        // 5. 校验 Token 是否合法、是否过期
        try {
            JwtUtils.validateToken(token);
            return true; // 校验通过，放行
        } catch (Exception e) {
            response.setStatus(401); // Token 无效或过期
            return false;
        }
    }
}