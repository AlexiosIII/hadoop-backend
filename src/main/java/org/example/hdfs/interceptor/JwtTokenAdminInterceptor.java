package org.example.hdfs.interceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.hdfs.common.properties.JwtProperties;
import org.example.hdfs.common.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: JwtTokenAdminInterceptor
 * Package: org.example.hdfs.interceptor
 * Description:jwt的拦截器,判断用户是否进行登录
 *
 * @Author: Alexios
 * @Create: 2024/10/18 - 16:40
 * @Version: v1.0
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验jwt
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //当发起跨域请求时，由于安全的原因，在触发一定条件时浏览器会在正式请求之前自动先发起OPTIONS请求，
        // 即预检请求，后端若接受该跨域请求，浏览器才继续发起正式请求。这里是为了不拦截跨域请求.
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader(jwtProperties.getUserTokenName());
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getUserSecretKey(), token);
            Integer userId = Integer.valueOf(claims.get("userId").toString());
            log.info("用户id:{}", userId);
            return true;
        } catch (Exception ex) {
            response.setStatus(401);
            return false;
        }
    }
}
