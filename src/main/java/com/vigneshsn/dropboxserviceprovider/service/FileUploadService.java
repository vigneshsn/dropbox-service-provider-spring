package com.vigneshsn.dropboxserviceprovider.service;

import com.vigneshsn.dropboxserviceprovider.model.FileInformation;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileInformation uploadFile(MultipartFile file);
}
