package com.humanfriendly.exeption;

import com.humanfriendly.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @Order(HIGHEST_PRECEDENCE)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(
            Exception exception) {
        LOGGER.error("Bad request message: {},Error Code: {}", exception.getMessage(), BAD_REQUEST);
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .description(exception.getMessage())
                        .build(),
                BAD_REQUEST);
    }

}