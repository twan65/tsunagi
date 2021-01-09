package com.tsunagi.app.constant;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

/**
 * Enum Converterを作成するときは、このクラスを継承する必要がある。
 * @param <X> 変換Enum名
 * @param <Y> Enum値の型
 */
public abstract class AbstractBaseEnumConverter<X extends Enum<X> & BaseEnumCode<Y>, Y> implements AttributeConverter<X, Y> {

    protected abstract X[] getValueList();

    @Override
    public Y convertToDatabaseColumn(X attribute) {
        return attribute.getValue();
    }

    @Override
    public X convertToEntityAttribute(Y dbData) {
        return Arrays.stream(getValueList())
                .filter(e -> e.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", dbData)));
    }
}
