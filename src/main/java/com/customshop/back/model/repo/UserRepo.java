package com.customshop.back.model.repo;

import com.customshop.back.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String name);

}
