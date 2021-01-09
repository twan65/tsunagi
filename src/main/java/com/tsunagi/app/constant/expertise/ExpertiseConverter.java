package com.tsunagi.app.constant.expertise;

import com.tsunagi.app.constant.AbstractBaseEnumConverter;
import com.tsunagi.app.constant.gender.Gender;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ExpertiseConverter extends AbstractBaseEnumConverter<Expertise, Integer> {

  @Override
  protected Expertise[] getValueList() {
    return Expertise.values();
  }
}
