package com.pavolpodstreleny.CloudStorage.service;

import java.util.List;

import com.pavolpodstreleny.CloudStorage.entity.File;
import com.pavolpodstreleny.CloudStorage.mapper.FileMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileService {

    @Autowired
    private FileMapper fileMapper;

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
