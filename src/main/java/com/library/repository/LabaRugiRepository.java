package com.library.repository;

import com.library.common.DKprimeryKey;
import com.library.entity.LabaRugiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LabaRugiRepository extends JpaRepository<LabaRugiEntity, DKprimeryKey> {


    @Query(value = "SELECT * FROM LABA_RUGI WHERE TGL_PELAPORAN = :tglLapor ORDER BY NO_KOMPONEN", nativeQuery = true)
    List<LabaRugiEntity> findAllData(@Param("tglLapor") Date tglLapor);
    @Query(value = "SELECT * FROM LABA_RUGI WHERE TGL_PELAPORAN = :tglLapor AND KD_KOMPONEN = :kdKomponen  ", nativeQuery = true)
    LabaRugiEntity findByIdData (@Param("tglLapor") Date tglLapor, @Param("kdKomponen") String kdKomponen);

//    @Query(value = "SELECT * FROM LABA_RUGI WHERE TGL_PELAPORAN = :tglLapor AND PARENT_KODE IS NOT NULL ORDER BY ID ASC ", nativeQuery = true)
//    List<LabaRugiEntity>findAllDataWhitParentCode(@Param("tglLapor")Date tglLapor);


//    LabaRugiEntity findByTglLporAndKdKomponen(@Param("tglLapor") Date tglLapor, @Param("kdKomponen") String kdKomponen);
    
}
