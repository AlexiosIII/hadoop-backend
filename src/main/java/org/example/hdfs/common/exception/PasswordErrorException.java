package org.example.hdfs.common.exception;

/**
 * ClassName: PasswordErrorException
 * Package: org.example.hdfs.exception
 * Description: 用户输入密码错误的异常
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 19:10
 * @Version: v1.0
 */
public class PasswordErrorException extends BaseException {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }

}
