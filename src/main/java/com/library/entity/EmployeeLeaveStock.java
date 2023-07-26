package com.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_LEAVE_STOCK")
public class EmployeeLeaveStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter @Setter private Long id;

    @Column(name = "NAMA_KARYAWAN")
    @Getter @Setter private String employeeName;

    @Column(name = "STOCK")
    @Getter @Setter private Long stock;
@Column(name = "STATUS")
@Getter @Setter private String status;
}
