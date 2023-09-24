package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitRegistrationVO {


    @Column(unique = true)
    @Pattern( regexp = "[A-Za-z0-9@._-]{8,50}$", message = "Username format is incorrect")
    @NotNull
    private String username;
    @Column(unique = true)
    @NotNull
    private String password;
    @Column(unique = true)
    @Pattern( regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,4}$", message = "Email format is incorrect")
    @NotNull
    private String email;
    @NotNull
    private String role;




}
