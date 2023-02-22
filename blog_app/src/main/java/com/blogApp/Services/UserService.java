package com.blogApp.Services;

import com.blogApp.Payload.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUser();
    void deleteUser(Integer userId);

}
