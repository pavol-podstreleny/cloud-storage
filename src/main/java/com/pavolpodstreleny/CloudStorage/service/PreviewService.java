package com.pavolpodstreleny.CloudStorage.service;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: rsv
 * Date: 02.10.2020
 * Time: 22:37
 */
@Service
public class PreviewService {

    public String getPreviewUrl(final String filename, final String contentType) {
        if (contentType.contains("image")) {
            return "/files/" + filename;
        }
        else {
            int lastDot = filename.lastIndexOf(".");
            if (lastDot == -1) {
                return "/img/preview/unknown.svg";
            }
            String extension = filename.substring(lastDot + 1);
            return "/img/preview/" + extension + ".svg";
        }
    }
}
