package com.womakerscode.auth.server.service;

import com.womakerscode.auth.server.controller.request.UserRequest;
import com.womakerscode.auth.server.model.entity.User;

public interface UserService {
    User save(UserRequest userRequest);
}
