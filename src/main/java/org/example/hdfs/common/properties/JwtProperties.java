package org.example.hdfs.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * ClassName: UserDTO
 * Package: org.example.hdfs.properties
 * Description: 存储的Jwt配置,具体信息在application.yml下
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 19:26
 * @Version: v1.0
 */
@Component
@ConfigurationProperties(prefix = "user.jwt")
@Data
public class JwtProperties {
    //用户的密钥
    private String userSecretKey;
    //用户token的持续事件
    private long userTtl;
    //前端传递过来的令牌名称
    private String userTokenName;
}
