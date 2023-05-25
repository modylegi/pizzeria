package ru.itis.semesterwork.mappers;

import org.mapstruct.Mapper;
import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    List<UserDto> toDto(List<User> users);
    User toUser(UserDto userDto);
}
