package com.liulich3ng.repository;

import com.liulich3ng.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Integer integer);

    @Override
    Page<User> findAll(Pageable pageable);
}
