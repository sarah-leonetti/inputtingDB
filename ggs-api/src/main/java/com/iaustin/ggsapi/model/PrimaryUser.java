package com.iaustin.ggsapi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


public class PrimaryUser extends User {


    @Id
    @OneToOne
    @JoinColumn(name = "id")
    public Long id; 
    //from user table
    @Column(nullable = false) // for the demo , we will have this commented because we will have elderly sign up on their own. we will  need guardians for the MVP
    @Id
    @ManyToOne
    @JoinColumn(name = "guardian_id") //JOIN COLUMN  = FOREIGN KEY ...MAPPED BY =OWNING
    
    public Long guardianId; //from guardian table

    private String guardianNotes; //from guardian table
    private String primaryNotes;
    private Boolean isActive;
    private String computer;
    private String tablet;
    private String phone;


}
