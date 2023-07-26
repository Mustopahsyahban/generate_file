package com.library.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "RBB_22C00")
public class RBB_22C00Entity  implements Serializable {


    private static final long serialVersionUID = -5637588015397678115L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private Long id;

    @Column(name = "TGL_PELAPORAN")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date tglPelaporan;


    @Column(name = "KD_KOMPONEN")
    @Getter @Setter
    private String kdKomponen;
    @Column(name = "NO_KOMPONEN")
    @Getter @Setter
    private String noKomponen;
    @Column(name = "PARENT_KODE")
    @Getter @Setter
    private String parentKode;

    @Column(name = "NM_KOMPONEN")
    @Getter @Setter
    private String nmKomponen;

    @Column(name = "REALISASI_T3")
    @Getter @Setter
    private BigDecimal realisaiT3;

    @Column(name = "T4_MIN_1")
    @Getter @Setter
    private BigDecimal t4Min1;
    @Column(name = "T1")
    @Getter @Setter
    private BigDecimal t1;

    @Column(name = "T2")
    @Getter @Setter
    private BigDecimal t2;
    @Column(name = "T3")
    @Getter @Setter
    private BigDecimal t3;
    @Column(name = "T4")
    @Getter @Setter
    private BigDecimal t4;

    @Column(name = "T4_PLUS_1")
    @Getter @Setter
    private BigDecimal t4Plus1;
    @Column(name = "T4_PLUS_2")
    @Getter @Setter
    private BigDecimal t4Plus2;

    @Column(name = "STATUS")
    @Getter @Setter
    private String status;

    @Column(name = "INCLUDE_TEXT")
    @Getter @Setter
    private String inculdeText;

    @Column(name = "DATE_ENTRY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date dateEntry;

    @Column(name = "DATE_UPDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date dateUpdate;




    public RBB_22C00Entity(Long id,Date tglPelaporan, String kdKomponen, String nmKomponen, BigDecimal realisaiT3, BigDecimal t4Min1, BigDecimal t1, BigDecimal t2, BigDecimal t3, BigDecimal t4, BigDecimal t4Plus1, BigDecimal t4Plus2) {
        this.id = id;
        this.tglPelaporan = tglPelaporan;
        this.kdKomponen = kdKomponen;
        this.nmKomponen = nmKomponen;
        this.realisaiT3 = realisaiT3;
        this.t4Min1 = t4Min1;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t4Plus1 = t4Plus1;
        this.t4Plus2 = t4Plus2;
    }
}
