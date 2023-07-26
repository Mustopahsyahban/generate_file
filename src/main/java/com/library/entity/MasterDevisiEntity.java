package com.library.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "MST_MASTER_DEVISI")
public class MasterDevisiEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEVISI")
    @Getter @Setter private Long id;

    @Column(name = "NAMA_DEVISI")
    @Getter @Setter private String name;



    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MasterDevisiEntity master = new MasterDevisiEntity();
        int rowCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= rowCount; i++) {

        }
        master.setId(rs.getLong("ID_DEVISI"));
        master.setName(rs.getString("NAMA_DEVISI"));


        return master;
    }

}
