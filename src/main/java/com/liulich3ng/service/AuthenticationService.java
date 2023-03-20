package com.liulich3ng.service;


import com.liulich3ng.entity.User;
import com.liulich3ng.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String register(String username, String password, String phone, String code) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .lastLogin(new Date())
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return token;
    }

    public String login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        //todo: 这里为什么需要和数据库通讯三次啊？？
        User user = userRepository.findByUsername(username).orElseThrow();
        user.setLastLogin(new Date());
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }
}
