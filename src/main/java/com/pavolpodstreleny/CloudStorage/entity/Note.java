package com.pavolpodstreleny.CloudStorage.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Note {

    private Integer id;
    private String title;
    private String description;
    private Integer userId;

}