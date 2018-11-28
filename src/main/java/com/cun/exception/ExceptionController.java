package com.cun.exception;

import com.cun.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RBACException.class)
    public Map<String, Object> AccountExceptionHandler(Exception e) {
        return R.fail(e.getMessage());
    }

}