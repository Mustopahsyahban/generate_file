package com.library.repository;

import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.MasterDevisiEntity;
import com.library.entity.MasterPeriodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterDevisiRepository extends JpaRepository<MasterDevisiEntity,Long> {

    @Query("""
			SELECT new com.library.dto.dropDwonDTO.DropDownDTO(pro.name, pro.name) 
			FROM MasterDevisiEntity AS pro 
			ORDER BY pro.name""")
    public List<DropDownDTO> findAllDevisiName();
}
