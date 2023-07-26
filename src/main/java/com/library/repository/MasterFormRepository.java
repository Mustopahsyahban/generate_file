package com.library.repository;

import com.library.entity.MasterForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterFormRepository extends JpaRepository<MasterForm, String> {



    @Query(value = "SELECT DESCRIPTION FROM MASTER_FORM WHERE CODE_FROM=:kdForm", nativeQuery = true)
    String getDecriptionByKdForm(@Param("kdForm") String kdForm);
}
