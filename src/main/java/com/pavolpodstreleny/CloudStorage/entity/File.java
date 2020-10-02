package com.pavolpodstreleny.CloudStorage.entity;

import java.util.StringJoiner;

public class File {

    private Integer id;
    private String fileName;
    private String contentType;
    private String fileSize;
    private Integer userId;
    private byte[] data;

    public File(Integer id, String fileName, String contentType, String fileSize, Integer userId, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.data = data;
    }

    public File(String fileName, String contentType, String fileSize, Integer userId, byte[] data) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getProperSize() {

        final double actualSize = Double.parseDouble(fileSize);
        if (actualSize == 0) {
            return "1B";
        }

        final double MB = (actualSize / (1024 * 1024));
        if (MB > 1) {
            return String.format("%.0f MB", MB);

        }

        final double KB = (actualSize / (1024));
        if (KB > 1) {
            return String.format("%.0f KB", KB);
        }

        return String.format("%.0f B", actualSize);

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", File.class.getSimpleName() + "[", "]").add("id=" + id).add("fileName='" + fileName + "'")
                                                                            .add("contentType='" + contentType + "'")
                                                                            .add("fileSize='" + fileSize + "'")
                                                                            .add("userId=" + userId).toString();
    }
}
