package com.example.base;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class uploadFiles {

    public String uploadImg(MultipartFile uploadFile) throws IOException {
        // 获取上传的文件名
        if (uploadFile != null) {
            String fileName = uploadFile.getOriginalFilename();
            // 获得文件后缀名例如.png
            String lastName = fileName.substring(fileName.lastIndexOf("."));
            File directory = new File("E:\\data", fileName);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            uploadFile.transferTo(directory);

            return directory.toString();


        }
        return "上传失败";
    }
}
