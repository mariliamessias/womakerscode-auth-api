package com.womakerscode.auth.server.controller;

import com.womakerscode.auth.server.controller.request.UserRequest;
import com.womakerscode.auth.server.controller.response.UserResponse;
import com.womakerscode.auth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
        return userService.save(userRequest).toUserResponse();
    }
}
