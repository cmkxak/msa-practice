package me.project.common.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(CmPayExcetion.class)
    public ErrorResponse exceptionHandler(CmPayExcetion e) {
        return ErrorResponse.create(e, HttpStatus.OK,
                e.getErrorCode().getMessage());
    }


}