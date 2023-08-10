package com.marvel.openpay.api.repository;

import com.marvel.openpay.api.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable, String> {

    UserTable findByUsername(String username);
}
