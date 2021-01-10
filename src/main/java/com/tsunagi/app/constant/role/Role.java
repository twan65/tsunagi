package com.tsunagi.app.constant.role;

import com.tsunagi.app.constant.BaseEnumCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role implements BaseEnumCode<Integer> {
    ADMIN(0),
    ADVISOR(1),
    USER(2);

    private final Integer role;

    @Override
    public Integer getValue() {
        return role;
    }
}
