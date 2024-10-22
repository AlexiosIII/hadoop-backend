package org.example.hdfs.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: UserDTO
 * Package: org.example.hdfs.pojo.dto
 * Description: 前端返回的user信息
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 19:26
 * @Version: v1.0
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String pwd;
}
