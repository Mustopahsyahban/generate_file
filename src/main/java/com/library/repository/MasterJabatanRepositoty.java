package com.library.repository;

import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.MasterJabatanEntity;
import com.library.entity.MasterPeriodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterJabatanRepositoty extends JpaRepository<MasterJabatanEntity,Long> {

    @Query("""
			SELECT new com.library.dto.dropDwonDTO.DropDownDTO(pro.name, pro.name)
			FROM MasterJabatanEntity AS pro 
			ORDER BY pro.name
			""")
    public List<DropDownDTO> findAllJabatanName();
}
