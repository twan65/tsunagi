package com.tsunagi.app.constant.expertise;

import com.tsunagi.app.constant.BaseEnumCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Expertise implements BaseEnumCode<Integer> {
  WEB_DEVELOP(0),
  MANAGEMENT(1);
  // TODO: 今後、必要な分野を追加していく。

  private final Integer expertiseCode;

  @Override
  public Integer getValue() {
    return expertiseCode;
  }
}
