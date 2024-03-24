package edu.pes.service;

import edu.pes.dto.UserDto;
import edu.pes.entity.User;

import java.util.List;

public interface UserServiceInterface {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
