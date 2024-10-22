package org.example.hdfs.service;

import org.example.hdfs.common.pojo.dto.UserDTO;
import org.example.hdfs.common.pojo.entity.User;

/**
 * ClassName: UserService
 * Package: org.example.hdfs.service
 * Description:
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 19:24
 * @Version: v1.0
 */
public interface UserService {

    User login(UserDTO userDTO);
    void register(UserDTO userDTO);
}
