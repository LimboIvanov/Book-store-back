package com.onlinebookstore.bookstoreback2.dto;

import com.onlinebookstore.bookstoreback2.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class UserDto {

    private Long id;

    @EqualsAndHashCode.Include
    private String username;

    @ToString.Exclude
    private String password;

    @EqualsAndHashCode.Include
    private String firstName;

    @EqualsAndHashCode.Include
    private String lastName;

    private String email;

    private Role role;

}
