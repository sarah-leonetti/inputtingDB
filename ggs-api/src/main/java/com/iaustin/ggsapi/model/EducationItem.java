package com.iaustin.ggsapi.model;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.mapping.List;
import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.EnumType;
import java.util.*;
import lombok.Data;

enum EducationItemTypeEnum {
    article("ARTICLE"),
    video("VIDEO");
    String type;

    EducationItemTypeEnum(String type){
        this.type = type;
    }
}

enum EducationItemCategoryEnum {
    scams("SCAMS"),
    device("DEVICE"),
    generalsaftey("GENERAL SAFETY"),
    stories("STORIES") ,
    promotional("PROMOTIONAL");
    String category;

    EducationItemCategoryEnum(String category){
        this.category = category;
    }
}


@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class EducationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   //@OneToOne(mappedBy = "item")
   // @PrimaryKeyJoinColumn
   //private Set<EducationItem> items;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EducationItemCategoryEnum categoryId; // category

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EducationItemTypeEnum type;

    @CreationTimestamp
    private ZonedDateTime date_uploaded;
    private Boolean isActive;
}

// DONT HAVE GRANTED ACCESS FOR MVN SO CANNOT TEST THIS YET- looking into it