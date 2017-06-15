package com.gluteen.model;

import com.gluteen.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 1.06.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileInformation implements Serializable {

    @NotNull
    private Long id;
    @NotEmpty
    @Size(min = 4,max = 15)
    private String firstName;
    @NotEmpty
    @Size(min = 4,max = 15)
    private String LastName;
    @NotEmpty
    @Size(min = 4,max = 15)
    private String about;
    @NotEmpty
    @DateTimeFormat(pattern = "MM/dd/yyyy")@Past
    private Date birthDate;
    @NotEmpty
    @Pattern(regexp = "[0-9]{5,15}")
    private String phone;
    @NotEmpty
    @Email
    @Size(min = 4,max = 15)
    private String email;
    @NotEmpty
    @Size(min = 4,max = 15)
    private String city;
    @NotEmpty
    @Size(min = 4,max = 15)
    private Gender gender;

}
