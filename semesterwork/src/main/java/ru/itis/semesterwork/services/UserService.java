package ru.itis.semesterwork.services;

import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.User;

import java.util.List;


public interface UserService  {
    List<UserDto> getUsers();
    UserDto createUser(User user);

//    User findByEmail(String email);


    void deleteUser(Long userId);


    UserDto updateUser(Long userId, String firstName, String lastName, String email, Integer age, String password);
}
