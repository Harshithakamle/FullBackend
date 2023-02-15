package com.FullBackend.services;

import com.FullBackend.entities.User;
import com.FullBackend.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,long id);
    UserDto getUserById(long id);
    List<UserDto> getAllUsers();
    void deleteUser(long id);

}
