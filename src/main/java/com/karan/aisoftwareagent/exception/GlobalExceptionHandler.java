
package com.karan.aisoftwareagent.exception;

import com.karan.aisoftwareagent.dto.AskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AskResponse> handleValidation(
            MethodArgumentNotValidException ex) {

        return ResponseEntity.badRequest().body(
                new AskResponse(
                        false,
                        null,
                        "Prompt cannot be empty."
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AskResponse> handleException(
            Exception ex) {

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(
                new AskResponse(
                        false,
                        null,
                        "AI service is temporarily unavailable."
                )
        );
    }
}
