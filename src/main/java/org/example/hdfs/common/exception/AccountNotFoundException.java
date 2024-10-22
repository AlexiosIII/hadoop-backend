package org.example.hdfs.common.exception;

/**
 * ClassName: AccountNotFoundException
 * Package: org.example.hdfs.exception
 * Description: 当用户登录发现该账户不存在的异常
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 20:11
 * @Version: v1.0
 */
public class AccountNotFoundException extends BaseException {
    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
