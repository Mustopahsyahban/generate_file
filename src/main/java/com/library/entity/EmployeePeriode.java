package com.library.entity;

import com.library.common.CommonEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "MST_EMPLOYEE_PERIODE")
public class EmployeePeriode implements Serializable {

    private static final long serialVersionUID = -5637588015397678115L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter @Setter private Long id;

    @Column(name = "NAMA")
    @Getter @Setter private String name;

    @Column(name ="JABATAN")
    @Getter @Setter private String jabatan;

    @Column(name ="NAMA_DEVISI")
    @Getter @Setter private String namaDevisi;

    @Column(name ="PERIODE")
    @Getter @Setter private String periode;

    @Column(name ="STATUS")
    @Getter @Setter private String status;

    @Column(name ="DELETE_STATUS")
    @Getter @Setter private Long deleteStatus;

    @Column(name = "DATE_CREATED")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter private Date dateCreated;

    @Column(name = "DATE_UPDATED")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter private Date dateUpdated;

    @Column(name = "DATE_DELETED")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter private Date dateDeleted;


    public EmployeePeriode(Long id, String name, String jabatan, String namaDevisi, String periode, String status) {
        this.id = id;
        this.name = name;
        this.jabatan = jabatan;
        this.namaDevisi = namaDevisi;
        this.periode = periode;
        this.status = status;
    }
}
