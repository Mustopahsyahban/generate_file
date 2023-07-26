package com.library.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "MASTER_JABATAN")
public class MasterJabatanEntity {


    @Column(name = "ID_JABATAN")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column(name = "NAMA_JABATAN")
    @Getter @Setter private String name;


}
