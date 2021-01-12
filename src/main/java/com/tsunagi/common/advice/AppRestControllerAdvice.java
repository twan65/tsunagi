package com.tsunagi.common.advice;

import com.tsunagi.common.constant.MessageCode;
import com.tsunagi.common.dto.ErrorResponseDto;
import com.tsunagi.common.exception.NoSearchResultException;
import com.tsunagi.common.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@Slf4j
@RestControllerAdvice
public class AppRestControllerAdvice {

  @Autowired
  MessageHelper messageHelper;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
    log.error("エラー内容：" + e);

    return new ResponseEntity<>(ErrorResponseDto.builder()
            .errorCode(MessageCode.E00001.getCode())
            .errorMessage(messageHelper.getMessage(MessageCode.E00001))
            .build(),
            HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NoSearchResultException.class)
  public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(NoSearchResultException e) {
    log.info(e.getMessage());

    return new ResponseEntity<>(
        ErrorResponseDto.builder()
            .errorCode(e.getMessageCode().getCode())
            .errorMessage(messageHelper.getMessage(e.getMessageCode()))
            .build(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<ErrorResponseDto> handleBindException(BindException e) {
    log.info(e.getMessage());

    return new ResponseEntity<>(
            ErrorResponseDto.builder()
                    .errorCode(MessageCode.E00003.getCode())
                    .errorMessage(messageHelper.getMessage(MessageCode.E00003))
                    .build(),
            HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
