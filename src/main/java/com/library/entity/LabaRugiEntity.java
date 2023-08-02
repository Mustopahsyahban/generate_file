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
@Table(name = "LABA_RUGI")
@IdClass(DKprimeryKey.class)
public class LabaRugiEntity implements Serializable {



    @Id
    @Column(name = "TGL_PELAPORAN")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date tglPelaporan;

     @Id
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

    @Column(name = "DETAIL")
    @Getter @Setter
    private BigDecimal detail;

    @Column(name = "MAX_SUM")
    @Getter @Setter
    private BigDecimal maxSum;

    @Column(name = "STATUS")
    @Getter @Setter
    private String status;

    @Column(name = "DATE_ENTRY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date dateEntry;

    @Column(name = "DATE_UPDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date dateUpdate;

    public LabaRugiEntity(Date tglPelaporan, String kdKomponen, String nmKomponen, BigDecimal detail, BigDecimal maxSum) {
        this.tglPelaporan = tglPelaporan;
        this.kdKomponen = kdKomponen;
        this.nmKomponen = nmKomponen;
        this.detail = detail;
        this.maxSum = maxSum;
    }
}
