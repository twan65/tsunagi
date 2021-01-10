package com.tsunagi.app.constant.gender;

import com.tsunagi.app.constant.BaseEnumCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender implements BaseEnumCode<Integer> {
  MAN(0),
  WOMEN(1);

  private final Integer genderCode;

  @Override
  public Integer getValue() {
    return genderCode;
  }
}
