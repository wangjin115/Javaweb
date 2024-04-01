package com.wj.filter;

import com.github.pagehelper.BoundSqlInterceptor;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author wj
 * @version 1.0
 */

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override//初始化方法，调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    @Override//拦截到请求后调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 拦截到了请求。。。放行前逻辑");
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Demo 拦截到了请求。。。放行后逻辑");
    }

    @Override//销毁方法，调用一次
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
