package com.learnspring.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

//    @NotNull //accepts everything except Null - but accepts ""
//    @NotEmpty //doesn't accept Null but accepst " "
//    @NotBlank// doesn't accept Null , empty String or only space

    @NotBlank //(message = "") -> will display error in the counsel
    @Size(max = 12, min =2) //tells controller to validate it
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
