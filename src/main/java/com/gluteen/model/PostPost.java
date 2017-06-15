package com.gluteen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by yusufaslan on 2.06.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPost implements Serializable {

    //BÖYLE BİR SINIFA İHTİYAÇ OLMAYABİLİR CONTROLLER YaZARKEN BURAYA TEKRAR DÖN

    @NotNull
    private Long post;

    @NotNull
    private Long postTitle;


    private Long postImage;

    @NotEmpty
    private String postBody;





}
