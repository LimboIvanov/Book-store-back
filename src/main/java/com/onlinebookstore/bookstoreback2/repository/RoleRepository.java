package com.onlinebookstore.bookstoreback2.repository;

import com.onlinebookstore.bookstoreback2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
