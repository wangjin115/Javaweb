package com.wj.exception;

import com.wj.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wj
 * @version 1.0
 */
@RestControllerAdvice //将方法的返回值转成json格式再响应回去
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //指定能够处理的异常类型
       public Result ex(Exception ex){
            ex.printStackTrace();//打印堆栈中的异常信息
//捕获到异常之后，响应一个标准的Result
       return Result.error("对不起,操作失败,请联系管理员"); }
}
