package com.library.repository;

import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.MasterPeriodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterPeriodeRepositoty extends JpaRepository<MasterPeriodeEntity,Long> {

    @Query("""
			SELECT new com.library.dto.dropDwonDTO.DropDownDTO(pro.jenisPeriode, pro.jenisPeriode) 
			FROM MasterPeriodeEntity AS pro 
			ORDER BY pro.id
			""")
    public List<DropDownDTO> findAllPeriodeName();
}
