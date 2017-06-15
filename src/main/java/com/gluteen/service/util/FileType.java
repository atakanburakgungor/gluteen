package com.gluteen.service.util;

/**
 * Created by yusufaslan on 2.06.2017.
 */
public enum FileType {



    POST_IMG_FILE("Post_img_file"),
    PROFIL_IMG_FILE("Profil_img_file");
   // PERFIL_CAPA_FILE("Perfil_capa_file");

    private final String name;

    FileType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
