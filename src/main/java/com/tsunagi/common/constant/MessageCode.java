package com.tsunagi.common.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageCode {
    SYSTEM_ERROR("E00001");

    private final String code;

}
