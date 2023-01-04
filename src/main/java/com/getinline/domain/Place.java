package com.getinline.domain;

import com.getinline.constant.PlaceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Place {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capactiy;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}