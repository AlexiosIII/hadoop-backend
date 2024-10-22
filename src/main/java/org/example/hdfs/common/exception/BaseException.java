package org.example.hdfs.common.exception;

/**
 * ClassName: BaseException
 * Package: org.example.hdfs.exception
 * Description: 自己定义异常的基类
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 20:10
 * @Version: v1.0
 */
public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }
}
