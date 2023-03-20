package com.liulich3ng.controller;

import com.liulich3ng.entity.User;
import com.liulich3ng.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    public Page<User> findAll() {
        // todo: 返回太多关于用户的东西了
        Page<User> res = userService.findAll(0, 10);
        return res;
    }
}
