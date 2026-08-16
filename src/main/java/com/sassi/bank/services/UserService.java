package com.sassi.bank.services;

import com.sassi.bank.dto.AuthenticationRequest;
import com.sassi.bank.dto.AuthenticationResponse;
import com.sassi.bank.dto.LightUserDto;
import com.sassi.bank.dto.UserDto;

/**
 * @author Hatem SASSI
 */
public interface UserService extends AbstractService<UserDto> {

  Integer validateAccount(Integer id);

  Integer invalidateAccount(Integer id);

  AuthenticationResponse register(UserDto user);

  AuthenticationResponse authenticate(AuthenticationRequest request);

  Integer update(LightUserDto userDto);
}
