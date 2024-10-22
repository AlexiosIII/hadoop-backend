package org.example.hdfs.config;

import org.example.hdfs.interceptor.JwtTokenAdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebConfig
 * Package: org.example.hdfs.config
 * Description:
 *
 * @Author: Alexios
 * @Create: 2024/10/20 - 15:15
 * @Version: v1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenAdminInterceptor)
                .excludePathPatterns("/token","/user");
    }
}
