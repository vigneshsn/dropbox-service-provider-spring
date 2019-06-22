package com.vigneshsn.dropboxserviceprovider.service;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.vigneshsn.dropboxserviceprovider.model.FileInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
class DropBoxService implements FileUploadService{

    private static final String ACCESS_TOKEN = "<place holder for access token>";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public FileInformation uploadFile(MultipartFile file) {
        try {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("vigneshsn_testapp").build();
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            log.info("User {} and fileName {}"+ client.users().getCurrentAccount().getName().getGivenName(),
                    file.getOriginalFilename());
            FileMetadata metadata = client.files().uploadBuilder("/"+file.getOriginalFilename())
                    .uploadAndFinish(file.getInputStream());
            log.info("file uploaded successfully {} and path", metadata.getId(), metadata.getName());
            return new FileInformation(metadata.getId(), metadata.getName());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new RuntimeException("error uploading file!!!");
        }
    }
}
