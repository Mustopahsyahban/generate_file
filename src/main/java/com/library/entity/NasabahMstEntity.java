package com.library.entity;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "MST_MASTER_NASABAH")
public class NasabahMstEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NASABAH")
    @Getter @Setter private Integer id;

    @Column(name = "NAMA")
    @Getter @Setter private String name;

    @Column(name = "TEMPAT_LAHIR")
    @Getter @Setter private String tempatLahir;

    @Column(name = "TANGGAL_LAHIR")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter private LocalDate tanggalLahir;

    @Column(name = "ALAMAT")
    @Getter @Setter private String alamat;


    @Column(name = "PENGHASILAN")
    @Getter @Setter private Integer penghasilan;


    @Column(name = "JENIS_NASABAH")
    @Getter @Setter private String jenisNasabah;

    @Column(name = "ID_CUSTOMER")
    @Getter @Setter private String idCustomer;


}
