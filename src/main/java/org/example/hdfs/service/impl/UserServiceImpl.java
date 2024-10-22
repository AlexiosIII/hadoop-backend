package org.example.hdfs.service.impl;

import org.example.hdfs.common.constant.MessageConstant;
import org.example.hdfs.common.exception.AccountAlreadyExistException;
import org.example.hdfs.common.exception.AccountNotFoundException;
import org.example.hdfs.common.exception.PasswordErrorException;
import org.example.hdfs.mapper.UserMapper;
import org.example.hdfs.common.pojo.dto.UserDTO;
import org.example.hdfs.common.pojo.entity.User;
import org.example.hdfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: org.example.hdfs.service.impl
 * Description:
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 20:05
 * @Version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(UserDTO userDTO) {
        String userName = userDTO.getUserName();
        String pwd = userDTO.getPwd();
        User user = userMapper.getByUserName(userName);
        //当用户在数据库未查询到,则抛出账户未找到错误
        if(user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //当用户输入的密码与数据库对应的密码不一致时,抛出密码错误异常
        if(!pwd.equals(user.getPwd())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return user;
    }

    @Override
    public void register(UserDTO userDTO) {
        String userName = userDTO.getUserName();
        User exist = userMapper.getByUserName(userName);
        //当该账户可以在数据库查询到时,抛出用户已经存在异常
        if(exist != null) {
            throw new AccountAlreadyExistException(MessageConstant.ACCOUNT_ALREADY_EXIST);
        }
        String pwd = userDTO.getPwd();
        String userPath = "/"+userName;
        User user = User.builder()
                .userName(userName)
                .pwd(pwd)
                .userPath(userPath)
                .build();
        userMapper.insert(user);
    }
}
