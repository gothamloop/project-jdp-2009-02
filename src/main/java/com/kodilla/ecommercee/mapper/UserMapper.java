package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto) {
        return new User();
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto();
    }
}
