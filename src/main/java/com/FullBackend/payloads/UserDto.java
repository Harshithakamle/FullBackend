package com.FullBackend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    @NotEmpty
    @Size(min=4, message="username must be 4 charecters")
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String about;
}
