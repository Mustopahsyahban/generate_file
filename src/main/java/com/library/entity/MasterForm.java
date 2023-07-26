package com.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = " MASTER_FORM")
public class MasterForm {

    @Id
    @Column(name = "CODE_FROM")
    @Getter @Setter private String codeForm;

    @Column(name = "DESCRIPTION")
    @Getter @Setter private String description;

}
