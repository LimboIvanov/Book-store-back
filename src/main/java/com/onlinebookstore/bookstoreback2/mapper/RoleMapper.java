package com.onlinebookstore.bookstoreback2.mapper;

import com.onlinebookstore.bookstoreback2.dto.BookDto;
import com.onlinebookstore.bookstoreback2.dto.RoleDto;
import com.onlinebookstore.bookstoreback2.model.Book;
import com.onlinebookstore.bookstoreback2.model.Role;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleDto toDto(Role role);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<RoleDto> toDtos(List<Role> roleList);

    Role toEntity(RoleDto roleDto);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Role> toRoles(List<RoleDto> roleDtoList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Role role, RoleDto roleDto);

    @Named("update")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void update(@MappingTarget Role role, RoleDto roleDto);

}
