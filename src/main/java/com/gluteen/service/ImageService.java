package com.gluteen.service;

import com.gluteen.service.util.FileType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

/**
 * Created by yusufaslan on 2.06.2017.
 */
@Service
public final class ImageService {

    public boolean saveFile(MultipartFile file, FileType fileType) {
        try {
            String nameFile = file.getOriginalFilename();
            String directoryArchive = "";
            if(fileType == FileType.PROFIL_IMG_FILE){
                directoryArchive = "C:\\Users\\Arthur\\Documents\\GitHub\\FaceFut\\FaceFut\\social\\social-web\\src\\main\\resources\\static\\imgs\\perfil";
            }
            else if(fileType == FileType.POST_IMG_FILE){
                directoryArchive = "C:\\Users\\Arthur\\Documents\\GitHub\\FaceFut\\FaceFut\\social\\social-web\\src\\main\\resources\\static\\imgs\\post";
            }
//            else if(tipoArquivo == FileType.PERFIL_CAPA_FILE){
//                diretorioArquivo = "C:\\Users\\Arthur\\Documents\\GitHub\\FaceFut\\FaceFut\\social\\social-web\\src\\main\\resources\\static\\imgs\\capa";
//            }
            String pathFile = Paths.get(directoryArchive, nameFile).toString();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(pathFile)));
            stream.write(file.getBytes());
            stream.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



}
