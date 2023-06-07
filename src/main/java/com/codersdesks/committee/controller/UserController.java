package com.codersdesks.committee.controller;

import com.codersdesks.committee.dto.UserDTO;
import com.codersdesks.committee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }

}
