package com.prodemy.kelompok3.springminiproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

//import org.springframework.security.core.GrantedAuthority;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    @Column(unique = true)
    @NotNull
    private String username;
    
    @Getter
    @Setter
    @Column(unique = true)
    @NotNull
    private String email;

    @Getter
    @Setter
    @NotNull
    private String password;

    @Getter
    @Setter
    @NotNull
    private String role;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

	

	
}
