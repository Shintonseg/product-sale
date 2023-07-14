package com.sparksupport.productsales.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus httpStatus;
    private Object result;

    public ErrorResponse(HttpStatus httpStatus, Object result) {
        this.httpStatus = httpStatus;
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
