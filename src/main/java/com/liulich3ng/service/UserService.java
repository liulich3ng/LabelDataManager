package com.liulich3ng.service;

import com.liulich3ng.entity.User;
import com.liulich3ng.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean registerUser(User user) {
        return false;
    }

    public void updateLastLogin(String name, Date time) {
        User user = userRepository.findByUsername(name).orElseThrow();
        user.setLastLogin(time);
        userRepository.save(user);
    }

    public Page<User> findAll(int pageNum, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum, pageSize));
    }
}
