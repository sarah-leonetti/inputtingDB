package com.iaustin.ggsapi.model;

import com.iaustin.ggsapi.security.oauth2.OAuth2Provider;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;



/*
 * enum userRoleEnum {
   primary ("PRIMARY USER"),
    guardian ("GUARDIAN"),
    employee("EMPLOYEE");
    String role;

    userRoleEnum(String relation){
        this.role = role;
    }

}

 * 
 * 
 */


@Data
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToOne  - getting an error when I apply this
    private Long id;

    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private OAuth2Provider provider;

    private String providerId;

    public User(String username, String password, String name, String email, String role, String imageUrl, OAuth2Provider provider, String providerId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.imageUrl = imageUrl;
        this.provider = provider;
        this.providerId = providerId;
    }
}
