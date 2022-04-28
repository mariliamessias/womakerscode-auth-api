package com.womakerscode.auth.server.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.womakerscode.auth.server.model.RoleType;
import com.womakerscode.auth.server.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    private List<RoleType> roles;
}
