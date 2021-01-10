package com.tsunagi.common.advice;

import com.tsunagi.common.constant.MessageCode;
import com.tsunagi.common.dto.ErrorResponseDto;
import com.tsunagi.common.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AppRestControllerAdvice {

  @Autowired
  MessageHelper messageHelper;

  @ExceptionHandler(Exception.class)
  public ErrorResponseDto handleException(Exception e) {
    log.error("エラー内容：" + e);

    return ErrorResponseDto.builder()
            .errorCode(MessageCode.SYSTEM_ERROR.getCode())
            .errorMessage(messageHelper.getMessage(MessageCode.SYSTEM_ERROR))
            .build();
  }
}
