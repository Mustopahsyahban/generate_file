package com.library.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Account {
    @Id
    @Column(name = "Username")
    @Getter @Setter private String username;
    @Column(name = "Password")
    @Getter @Setter private String password;



}