package com.tericcabrel.jwt_security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;
}
