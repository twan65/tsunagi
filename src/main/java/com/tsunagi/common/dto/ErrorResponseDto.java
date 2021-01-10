package com.tsunagi.common.dto;

import lombok.Builder;
import lombok.Getter;

/** Error発生時、必要なレスポンス情報を定義する。 */
@Getter
public class ErrorResponseDto {

  private String errorCode;
  private String errorMessage;

  @Builder
  private ErrorResponseDto(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}
