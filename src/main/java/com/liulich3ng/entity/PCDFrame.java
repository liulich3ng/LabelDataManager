package com.liulich3ng.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
public class PCDFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    private boolean isKeyFrame = false;

    private String pcdURL;

    private String[] cameraURLs;


}
