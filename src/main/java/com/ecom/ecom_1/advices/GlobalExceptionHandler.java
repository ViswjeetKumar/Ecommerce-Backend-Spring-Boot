package com.ecom.ecom_1.advices;

import com.ecom.ecom_1.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>>resourceNotFoundHandler(ResourceNotFoundException exception){
 ApiError apiError = ApiError
         .builder()
         .status(HttpStatus.NOT_FOUND)
         .message(exception.getMessage())
         .build();
    return buildErrorApiResponse(apiError);
}

    private ResponseEntity<ApiResponse<?>> buildErrorApiResponse(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> haldleInputValidationError(MethodArgumentNotValidException exception){
    List<String> errors= exception
            .getBindingResult()
            .getAllErrors()
            .stream()
            .map(error->error.getDefaultMessage())
            .toList();
    ApiError apiError = ApiError.builder()
            .status(HttpStatus.BAD_REQUEST) // Bad Request:400
            .message("Input Validation Errors")
            .subErrors(errors)
            .build();
    return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
}
}
