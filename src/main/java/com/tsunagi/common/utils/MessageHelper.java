package com.tsunagi.common.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
public class MessageHelper {

  private final MessageSource messageSource;

  public String getMessage(String messageCode) {
    return this.getMessage(messageCode, null, Locale.getDefault());
  }

  public String getMessage(String messageCode, Object[] args) {
    return this.getMessage(messageCode, args, Locale.getDefault());
  }

  public String getMessage(String messageCode, Object[] args, Locale locale) {
    return messageSource.getMessage(messageCode, args, locale);
  }
}
