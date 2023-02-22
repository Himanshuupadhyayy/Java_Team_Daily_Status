package com.blogApp.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter

public class UserDTO {

    private int id;
    @NotEmpty
    @Size(min=4,message = "user must be of 4 characters")
    private String name;
    @Email(message = "email is not valid")
    private String email;
    @NotEmpty
    @Size(min=3, max = 10, message = "passward should contain all these")
    private String passward;
    @NotEmpty
    private String about;




}
