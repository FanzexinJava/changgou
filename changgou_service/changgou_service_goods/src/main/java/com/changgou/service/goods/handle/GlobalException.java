package com.changgou.service.goods.handle;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: 樊泽鑫
 * @Project: changgou_parent
 * @Pcakage: com.changgou.service.goods.handle.GlobalException
 * @Date: 2023年02月16日 22:11
 * @Description:
 */

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result<String> ExceptionHandle(){
        Result<String> result = new Result<>(false, StatusCode.ERROR,"系统出现未知异常！");
        return result;
    }

}
