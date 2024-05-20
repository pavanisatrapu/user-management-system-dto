package com.myprojects.usermanagementsystemdto.service;

import com.myprojects.usermanagementsystemdto.dto.UserDto;
import com.myprojects.usermanagementsystemdto.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);
    Optional<UserDto> getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    UserDto deleteUser(Long id);
}
