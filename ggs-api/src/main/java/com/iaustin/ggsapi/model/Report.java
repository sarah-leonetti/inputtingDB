package com.iaustin.ggsapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @NotNull
    private Long report_id;

    @Column(nullable = false)
    private String description; //user-provided description

    @NotNull
    private boolean isActive;

    private byte[] picture; //user-provided picture of issue
   
    private String report_type; //email related, browswer related, device related, etc.

    @NotNull
    //@ManyToOne(mappedby = 'users_id') //
    private String user;
    private Boolean ggs_fix;


    public Report(String description, String user) {
        this.description = description;
        this.user = user;
    }

    


}
