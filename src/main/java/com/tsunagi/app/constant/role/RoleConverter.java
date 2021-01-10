package com.tsunagi.app.constant.role;

import com.tsunagi.app.constant.AbstractBaseEnumConverter;
import com.tsunagi.app.constant.gender.Gender;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter extends AbstractBaseEnumConverter<Role, Integer> {

  @Override
  protected Role[] getValueList() {
    return Role.values();
  }
}
