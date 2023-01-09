package com.cocus.backendTask.exception;

import com.cocus.backendTask.exception.custom.APIRateLimitExceededException;
import com.cocus.backendTask.exception.custom.UserNotFoundException;
import com.cocus.backendTask.model.response.CustomErrorResponse;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.cocus.backendTask.exception.constant.ExceptionHandlerConstants.*;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(UserNotFoundException userNotFoundException, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(USERNAME_NOT_EXIST_STATUS_CODE, userNotFoundException.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(INTERNAL_ERROR_STATUS_CODE, exception.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(APIRateLimitExceededException.class)
    public ResponseEntity<?> handleAPIRateLimitExceededException(APIRateLimitExceededException exception, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(INTERNAL_ERROR_STATUS_CODE, exception.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(NOT_ACCEPTABLE_STATUS_CODE, ex.getMessage());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(customErrorResponse, headers, HttpStatus.NOT_ACCEPTABLE);
    }
}
