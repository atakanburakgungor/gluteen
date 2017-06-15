package com.gluteen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by yusufaslan on 1.06.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword implements Serializable{

    @NotNull
    @Size(min = 5, max = 15)
    private String currentPassword;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;

}
