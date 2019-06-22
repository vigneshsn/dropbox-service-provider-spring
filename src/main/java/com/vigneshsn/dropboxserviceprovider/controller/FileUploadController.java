package com.vigneshsn.dropboxserviceprovider.controller;

import com.vigneshsn.dropboxserviceprovider.service.FileUploadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file")MultipartFile file) {
        fileUploadService.uploadFile(file);
    }
}
