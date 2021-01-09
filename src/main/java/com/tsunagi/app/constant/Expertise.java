package com.tsunagi.app.constant;

public enum Expertise {
  WEB_DEVELOP(0),
  MANAGEMENT(1);
  // TODO: 今後、必要な分野を追加していく。

  private int expertiseCode;

  Expertise(int expertiseCode) {
    this.expertiseCode = expertiseCode;
  }
}
