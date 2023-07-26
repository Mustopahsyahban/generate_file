package com.library.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "MST_MASTER_PERIODE")
public class MasterPeriodeEntity {


    @Column(name = "ID_PERIODE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column(name = "JENIS_PERIODE")
    @Getter @Setter private String jenisPeriode;


}
