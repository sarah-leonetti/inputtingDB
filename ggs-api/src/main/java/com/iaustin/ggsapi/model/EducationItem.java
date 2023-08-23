package com.iaustin.ggsapi.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

enum EducationItemTypeEnum {
    article("ARTICLE"),
    video("VIDEO");
    String type;

    EducationItemTypeEnum(String type){
        this.type = type;
    }
}

@Data
@MappedSuperclass
public class EducationItem {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long categoryId; // category

    @Column(nullable = false)
    private EducationItemTypeEnum type;

    @CreationTimestamp
    private ZonedDateTime date_uploaded;
    private Boolean isActive;
}

// DONT HAVE GRANTED ACCESS FOR MVN SO CANNOT TEST THIS YET- looking into it