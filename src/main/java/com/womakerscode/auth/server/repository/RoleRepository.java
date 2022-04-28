package com.womakerscode.auth.server.repository;

import com.womakerscode.auth.server.model.RoleType;
import com.womakerscode.auth.server.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT q FROM Role q WHERE q.name=:name")
    Optional<Role> findByName(@Param("name") RoleType name);

}
