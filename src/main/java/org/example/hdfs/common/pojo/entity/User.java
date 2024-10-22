package org.example.hdfs.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: User
 * Package: org.example.hdfs.entity
 * Description:从数据库获取到的用户信息
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 17:53
 * @Version: v1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private String pwd;
    private String userPath;
}
