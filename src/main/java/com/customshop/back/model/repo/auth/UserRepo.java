package com.customshop.back.model.repo.auth;

import com.customshop.back.model.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String name);

    List<User> findAllByUserIdIn(Iterable<UUID> ids);

}
