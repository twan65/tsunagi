package com.tsunagi.app.constant;

/**
 * Enumを作成するときは、このインタフェースを継承する必要がある。
 * @param <T>
 */
public interface BaseEnumCode<T> {
    T getValue();
}
