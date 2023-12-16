package com.EmployeeMgmt.Exception;

import com.EmployeeMgmt.helper.ApiResponce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<ApiResponce> resourceNotFoundException(MyException ex){
        logger.info("Global Exception Handler Involved sucessfully!!");
        ApiResponce responce = ApiResponce.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);

    }
}
