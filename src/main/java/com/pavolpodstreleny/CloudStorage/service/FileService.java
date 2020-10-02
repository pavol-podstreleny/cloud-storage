package com.pavolpodstreleny.CloudStorage.service;

import com.pavolpodstreleny.CloudStorage.entity.File;
import com.pavolpodstreleny.CloudStorage.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class FileService {

    private final FileMapper fileMapper;

    public FileService(final FileMapper fileMapper) {this.fileMapper = fileMapper;}

    public int uploadFile(MultipartFile multipartFile, int userId) {
        File file = null;
        try {

            file = new File(multipartFile.getOriginalFilename(), multipartFile.getContentType(),
                    String.valueOf(multipartFile.getSize()), userId, multipartFile.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Problem occured while saving data into File table");
        }
        if (file != null)
            return fileMapper.insert(file);

        return -1;

    }

    public List<File> provideFiles(int userId) {
        return fileMapper.getFiles(userId);
    }

    public File provideFile(String fileName, int userId) {
        return fileMapper.getUserFileByFileName(userId, fileName);
    }

    public File provideFile(int fileId, int userId) {
        return fileMapper.getUserFileById(userId, fileId);
    }

    public int removeFile(int fileId) {
        return fileMapper.delete(fileId);
    }
}
