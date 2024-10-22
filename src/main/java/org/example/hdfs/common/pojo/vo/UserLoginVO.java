package org.example.hdfs.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: UserLoginVO
 * Package: org.example.hdfs.pojo.vo
 * Description: 发送给前端的用户信息
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 19:55
 * @Version: v1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO {
    private int userId;
    private String userName;
    private String userPath;
    private String token;
}
