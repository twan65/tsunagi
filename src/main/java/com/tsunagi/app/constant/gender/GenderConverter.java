package com.tsunagi.app.constant.gender;

import com.tsunagi.app.constant.AbstractBaseEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends AbstractBaseEnumConverter<Gender, Integer> {

  @Override
  protected Gender[] getValueList() {
    return Gender.values();
  }
}
