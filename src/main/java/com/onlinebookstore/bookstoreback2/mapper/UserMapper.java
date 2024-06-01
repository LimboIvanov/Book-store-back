package com.onlinebookstore.bookstoreback2.mapper;

import com.onlinebookstore.bookstoreback2.dto.UserDto;
import com.onlinebookstore.bookstoreback2.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {RoleMapper.class})
public interface UserMapper {

    User toEntity(UserDto dto);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<User> toEntities(List<UserDto> dtoList);

    UserDto toDto(User user);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<UserDto> toDtos(List<User> userList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void update(@MappingTarget User user, UserDto userDto);

}
