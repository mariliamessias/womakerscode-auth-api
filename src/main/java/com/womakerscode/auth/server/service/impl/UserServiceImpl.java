package com.womakerscode.auth.server.service.impl;

import com.womakerscode.auth.server.controller.request.UserRequest;
import com.womakerscode.auth.server.exceptions.BusinessException;
import com.womakerscode.auth.server.exceptions.ResourceNotFoundException;
import com.womakerscode.auth.server.model.RoleType;
import com.womakerscode.auth.server.model.entity.Role;
import com.womakerscode.auth.server.model.entity.User;
import com.womakerscode.auth.server.repository.RoleRepository;
import com.womakerscode.auth.server.repository.UserRepository;
import com.womakerscode.auth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public User save(UserRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getUserName())) {
            throw new BusinessException("user " + userRequest.getUserName() + " already created");
        }

        userRequest.setPassword(encoder.encode(userRequest.getPassword()));
        if (userRequest.getRole() == null) userRequest.setRole(RoleType.NORMAL);

        Role role = roleRepository.findByName(userRequest.getRole())
                .orElseThrow(() -> new ResourceNotFoundException("role name: " + userRequest.getRole() + " already not found"));

        return userRepository.save(userRequest.toSaveUser(Collections.singletonList(role)));
    }

}
