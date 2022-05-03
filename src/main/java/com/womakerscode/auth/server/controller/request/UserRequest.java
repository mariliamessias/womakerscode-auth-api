package com.womakerscode.auth.server.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.womakerscode.auth.server.model.RoleType;
import com.womakerscode.auth.server.validator.constraints.ValidPassword;
import com.womakerscode.auth.server.model.entity.Role;
import com.womakerscode.auth.server.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @Size(min = 5, message = "Usename minimun size equal to 5.")
    @JsonProperty("user_name")
    private String userName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @ValidPassword
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
