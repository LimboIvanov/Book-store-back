package com.onlinebookstore.bookstoreback2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class RoleDto {

    private Long id;

    private String name;

}
