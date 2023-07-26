package com.library.entity;


import com.library.common.CommonEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "MASTER_JENIS_NASABAH")
public class JenisCustomerMastertEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JENIS")
    @Getter @Setter private Integer id;

    @Column(name = "JENIS_NASABAH")
    @Getter @Setter private String name;



}
