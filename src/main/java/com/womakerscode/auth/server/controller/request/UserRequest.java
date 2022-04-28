package com.womakerscode.auth.server.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.womakerscode.auth.server.model.RoleType;
import com.womakerscode.auth.server.model.entity.Role;
import com.womakerscode.auth.server.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @JsonProperty("role")
    private RoleType role;

    @NotEmpty
    @Max(50)
    @JsonProperty("user_name")
    private String userName;

    @NotEmpty
    @Max(50)
    private String email;

    @NotEmpty
    @Max(50)
    private String password;

    public User toSaveUser(List<Role> roles) {
        return User.builder()
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .email(email)
                .roles(roles)
                .createdAt(LocalDateTime.now())
                .password(password)
                .username(userName)
                .build();
    }
}
