package com.ananthudev.EasyCart.exceptions;

import com.ananthudev.EasyCart.exceptions.customer.CustomerNotFoundException;
import com.ananthudev.EasyCart.exceptions.customer.DuplicateCustomerException;
import com.ananthudev.EasyCart.exceptions.seller.DuplicateSellerException;
import com.ananthudev.EasyCart.exceptions.seller.SellerInvalidCredentialException;
import com.ananthudev.EasyCart.exceptions.seller.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateCustomerException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateCustomer(DuplicateCustomerException duplicateCustomerException){
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","Duplicate customer");
        errorBody.put("message",duplicateCustomerException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","customer not found");
        errorBody.put("message",customerNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleSellerNotFoundException(SellerNotFoundException sellerNotFoundException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","seller not found");
        errorBody.put("message",sellerNotFoundException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateSellerException.class)
    public ResponseEntity<Map<String,Object>> handleDuplicateSellerException(DuplicateSellerException duplicateSellerException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","seller already exist with given email");
        errorBody.put("message",duplicateSellerException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SellerInvalidCredentialException.class)
    public ResponseEntity<Map<String,Object>> handleSellerInvalidCredentialException(SellerInvalidCredentialException sellerInvalidCredentialException){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("status",HttpStatus.BAD_REQUEST.value());
        errorBody.put("error","invalid credential");
        errorBody.put("message",sellerInvalidCredentialException.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<Map<String,Object>> handleGenericException(Exception exception){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorBody.put("error", "Internal Server Error");
        errorBody.put("message", exception.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
