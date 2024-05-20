package com.myprojects.usermanagementsystemdto.mapper;

import com.myprojects.usermanagementsystemdto.dto.UserDto;
import com.myprojects.usermanagementsystemdto.entity.User;

public class UserMapper {
    public static User mapToUser(UserDto userDto){
        return new User(userDto.getUserId(),
                userDto.getUserName(),
                userDto.getUserEmail(),
                userDto.getUserAge());
    }
    public static UserDto mapToUserDto(User user){
        return new UserDto(user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserAge());
    }
}
