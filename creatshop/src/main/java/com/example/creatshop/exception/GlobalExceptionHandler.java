package com.example.creatshop.exception;
/*
 * @author HongAnh
 * @created 23 / 09 / 2024 - 7:53 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.BlankData;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.util.MessageSourceUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GlobalExceptionHandler {
    MessageSource     messageSource;
    MessageSourceUtil messageSourceUtil;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GlobalResponse<Meta, BlankData>> handlerBadRequestException(BadRequestException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(GlobalResponse
                        .<Meta, BlankData>builder()
                        .meta(Meta.builder()
                                  .status(Status.ERROR)
                                  .message(messageSourceUtil.getLocalizedMessage(ex.getMessage()))
                                  .build()
                        )
                        .build()
                );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GlobalResponse<Meta, BlankData>> handlerNotFoundException(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(GlobalResponse
                        .<Meta, BlankData>builder()
                        .meta(Meta.builder()
                                  .status(Status.ERROR)
                                  .message(messageSourceUtil.getLocalizedMessage(ex.getMessage()))
                                  .build()
                        )
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalResponse<Meta, Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = messageSourceUtil.getLocalizedMessage(error.getDefaultMessage());
            validationErrors.put(fieldName, errorMessage);
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(GlobalResponse
                        .<Meta, Map<String, String>>builder()
                        .meta(Meta.builder()
                                  .status(Status.ERROR)
                                  .message("Validation failed")
                                  .build()
                        )
                        .data(validationErrors)
                        .build()
                );
    }
}
