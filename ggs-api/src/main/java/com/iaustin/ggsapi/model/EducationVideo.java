package com.iaustin.ggsapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.MappedSuperclass;


enum VideoCategoryTypeEnum{
    scam( "SCAM"),
    device( "DEVICE"),
    general("GENERAL"),
    promotional("PROMOTIONAL");
    String category;

    VideoCategoryTypeEnum (String category){
        this.category = category;
    }
}




@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "tbl_education_video"

)
public class EducationVideo extends EducationItem {

    @Column(nullable = false)
    private String key; // youtube API key
    private VideoCategoryTypeEnum category;  //video category

}