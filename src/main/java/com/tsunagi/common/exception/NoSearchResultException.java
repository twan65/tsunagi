package com.tsunagi.common.exception;

import com.tsunagi.common.constant.MessageCode;
import lombok.Getter;

/**
 * 検索結果がない場合に使用するExceptionクラス
 * 使用時にはmessageCodeを渡す必要がある。
 */
@Getter
public class NoSearchResultException extends RuntimeException{

    private MessageCode messageCode;

    public NoSearchResultException(MessageCode messageCode) {
        super();
        this.messageCode = messageCode;
    }

    public NoSearchResultException(MessageCode messageCode, Throwable cause) {
        super(cause);
        this.messageCode = messageCode;
    }
}
