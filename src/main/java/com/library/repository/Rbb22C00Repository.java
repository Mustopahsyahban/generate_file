package com.library.repository;

import com.library.entity.RBB_22C00Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface Rbb22C00Repository extends JpaRepository< RBB_22C00Entity,Long> {


    @Query(value = "SELECT * FROM RBB_22C00 WHERE TGL_PELAPORAN = :tglLapor ORDER BY ID ASC ", nativeQuery = true)
    List<RBB_22C00Entity>findAllData(@Param("tglLapor")Date tglLapor);
    @Query(value = "SELECT * FROM RBB_22C00 WHERE ID = :id ", nativeQuery = true)
    RBB_22C00Entity findByIdData (@Param("id") Long id);

    @Query(value = "SELECT * FROM RBB_22C00 WHERE TGL_PELAPORAN = :tglLapor AND PARENT_KODE IS NOT NULL ORDER BY ID ASC ", nativeQuery = true)
    List<RBB_22C00Entity>findAllDataWhitParentCode(@Param("tglLapor")Date tglLapor);
}
