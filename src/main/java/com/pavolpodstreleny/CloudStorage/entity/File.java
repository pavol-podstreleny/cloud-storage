package com.pavolpodstreleny.CloudStorage.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class File {

    private Integer id;
    private String fileName;
    private String contentType;
    private String fileSize;
    private Integer userId;
    private byte[] data;

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
}
