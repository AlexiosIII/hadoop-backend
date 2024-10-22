package org.example.hdfs.common.exception;

/**
 * ClassName: AccountAlreadyExistsException
 * Package: org.example.hdfs.common.exception
 * Description: 当用户注册时,该用户名已被注册的异常
 *
 * @Author: Alexios
 * @Create: 2024/10/21 - 17:09
 * @Version: v1.0
 */
public class AccountAlreadyExistException extends BaseException {
    public AccountAlreadyExistException() {
    }
    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
