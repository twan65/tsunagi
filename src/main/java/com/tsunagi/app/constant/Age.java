package com.tsunagi.app.constant;

public enum Age {
    MAN(0),
    WOMEN(1);

    private int genderCode;

    Age(int genderCode) {
        this.genderCode = genderCode;
    }
}
