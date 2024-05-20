package com.myprojects.usermanagementsystemdto.service;

import com.myprojects.usermanagementsystemdto.mapper.UserMapper;
import com.myprojects.usermanagementsystemdto.dto.UserDto;
import com.myprojects.usermanagementsystemdto.entity.User;
import com.myprojects.usermanagementsystemdto.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        //dto to jpa entity
        User user= UserMapper.mapToUser(userDto);

        User savedUser =userRepository.save(user);

        //jpa entity to dto
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        Optional<User> user=userRepository.findById(id);
        return Optional.of(UserMapper.mapToUserDto(user.get()));
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserDto> userDtoList= new ArrayList<UserDto>();
        List<User> userList=userRepository.findAll();
        int userListSize=userList.size();
        for (int i=0;i<userListSize;i++){
            userDtoList.add(UserMapper.mapToUserDto(userList.get(i)));
        }
        return userDtoList;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user=new User(userDto.getUserId(), userDto.getUserName(), userDto.getUserEmail(), userDto.getUserAge());
        User existingUser=userRepository.findById(user.getUserId()).get();
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserAge(user.getUserAge());
        User updatedUser =userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public UserDto deleteUser(Long id) {
        User wantToDelete=userRepository.findById(id).get();
        userRepository.deleteById(id);
        return UserMapper.mapToUserDto(wantToDelete);
    }


}
