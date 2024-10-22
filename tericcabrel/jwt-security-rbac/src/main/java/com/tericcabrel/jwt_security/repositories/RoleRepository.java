package com.tericcabrel.jwt_security.repositories;

import com.tericcabrel.jwt_security.entities.Role;
import com.tericcabrel.jwt_security.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleEnum roleEnum);
}
