package com.library.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.*;
import java.time.LocalDate;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @Column(name = "MembershipNumber")
    @Getter @Setter private String membershipNumber;

    @Column (name = "firstName")
    @Getter @Setter private String firstName;

    @Column (name = "LastName")
    @Getter @Setter private String lastName;

    @Column (name = "BirthDate")
    @Getter @Setter private LocalDate birthDate;

    @Column (name = "Gender")
    @Getter @Setter private String gender;

    @Column (name="Phone")
    @Getter @Setter private String phone;

    @Column(name = "Address")
    @Getter @Setter private String address;

    @Column (name = "MembershipExpireDate")
    @Getter @Setter private LocalDate membershipExpireDate;

}
