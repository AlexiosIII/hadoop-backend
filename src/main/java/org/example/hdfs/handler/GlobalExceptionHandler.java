package org.example.hdfs.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.hdfs.common.exception.BaseException;
import org.example.hdfs.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: org.example.hdfs.handler
 * Description:统一处理异常,当发生异常时,传递错误信息给前端
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 21:01
 * @Version: v1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException ex) {
        log.error("异常信息: {}",ex.getMessage());
        return Result.error(ex.getMessage());
    }
}
