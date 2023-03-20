package com.liulich3ng.utils.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;
import java.util.Date;

public class FileUploadUtils {
    /**
     * 文件上传
     *
     * @param directory 相对应用的基目录
     * @param file      上传的文件
     * @return 上传成功的文件名
     */
    public static final String upload(String directory, MultipartFile file) throws IOException {
        String fileName = getNewName(file);
        File newFile = new File(directory + File.separator + fileName);
        String absPath = newFile.getAbsolutePath();
        if (!newFile.exists())
        {
            if (!newFile.getParentFile().exists())
            {
                newFile.getParentFile().mkdirs();
            }
        }
        file.transferTo(Paths.get(absPath));
        return fileName;
    }

    public static final String getNewName(MultipartFile file) {
        return System.currentTimeMillis() + file.getOriginalFilename();
    }
}
