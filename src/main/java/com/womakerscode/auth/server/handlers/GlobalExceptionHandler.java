package com.womakerscode.auth.server.handlers;

import com.womakerscode.auth.server.exceptions.BusinessException;
import com.womakerscode.auth.server.exceptions.GenericErrorsException;
import com.womakerscode.auth.server.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericErrorsException handleValidateException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return new GenericErrorsException(bindingResult);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericErrorsException handleResourceNotFoundException(ResourceNotFoundException e) {
        return new GenericErrorsException(e);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericErrorsException handleBusinessException(BusinessException e) {
        return new GenericErrorsException(e);
    }

}
