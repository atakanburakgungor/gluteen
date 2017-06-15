package com.gluteen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by yusufaslan on 1.06.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp implements Serializable {


    @NotEmpty
    @Size(min = 4,max = 15)
    private String firstName;

    @NotEmpty
    @Size(min = 4,max = 15)
    private String lastName;

    @NotEmpty
    @Email
    @Size(min = 4,max = 15)
    private String userName;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;

}
