package org.example.hdfs.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.hdfs.common.pojo.dto.UserDTO;
import org.example.hdfs.common.pojo.entity.User;
import org.example.hdfs.common.pojo.vo.UserLoginVO;
import org.example.hdfs.common.properties.JwtProperties;
import org.example.hdfs.common.result.Result;
import org.example.hdfs.common.utils.JwtUtil;
import org.example.hdfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: UserController
 * Package: org.example.hdfs.controller
 * Description:处理用户的controller
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 20:16
 * @Version: v1.0
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;
    @PostMapping("/token")
    public Result<UserLoginVO> login(@RequestBody UserDTO userDTO) {
        log.info("用户登录：{}", userDTO);
        //获取user对象
        User user = userService.login(userDTO);
        //jwt所携带的信息
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );
        //定义userLoginVO传递给前端
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .token(token)
                .userPath(user.getUserPath())
                .build();
        return Result.success(userLoginVO);
    }
    @PostMapping("/user")
    public Result register(@RequestBody UserDTO userDTO) {
        log.info("用户注册：{}", userDTO);
        //进行注册的检验
        userService.register(userDTO);
        return Result.success();
    }
}
