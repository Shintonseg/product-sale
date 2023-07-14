package com.sparksupport.productsales.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseMessage(String message, HttpStatus httpStatus, Object apiResponse){
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("message",message);
        response.put("status",httpStatus);
        response.put("result",apiResponse);
        return new ResponseEntity<>(response,httpStatus);
    }

}
