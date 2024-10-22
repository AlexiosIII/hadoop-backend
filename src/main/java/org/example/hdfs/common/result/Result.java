package org.example.hdfs.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Result
 * Package: org.example.hdfs.common.result
 * Description:统一的返回格式
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 20:38
 * @Version: v1.0
 */

/**
 * 后端统一的返回结果
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}