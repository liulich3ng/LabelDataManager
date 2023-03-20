package com.liulich3ng.controller;

import com.liulich3ng.utils.file.FileUploadUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DatasetController {
    @Value("${app.uploadPath}")
    private String uploadPath;

    @PostMapping("/datasets")
    public String createDataset(MultipartFile file) {
        String url;
        try {

            url = FileUploadUtils.upload(uploadPath, file);
        } catch (IOException e) {
            return null;
        }
        return url;
    }
}
