package com.powernode.springmvc.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/20 16:45
 * @description:
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置请求体的字符集
        servletRequest.setCharacterEncoding("UTF-8");
        // 设置响应体的字符集
        servletResponse.setContentType("text/html;charset=UTF-8");
        // 执行下一个资源
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
