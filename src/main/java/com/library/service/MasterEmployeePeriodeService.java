package com.library.service;


import com.library.repository.MstEmployeePeriodeRespository;
import com.library.entity.EmployeePeriode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class MasterEmployeePeriodeService {

    @Autowired
    MstEmployeePeriodeRespository repository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<EmployeePeriode> findAll (){
            Long criteria = 0l;
            List<EmployeePeriode> grid =
                    jdbcTemplate.query("SELECT * fROM MST_EMPLOYEE_PERIODE WHERE DELETE_STATUS = 0",
                            new EmployeePeriodeRowMapper());
            return grid;
        }



    public String save(EmployeePeriode dto) {

        if (dto.getId()==null) {
            //Created
            EmployeePeriode saveEntity = dto;
            saveEntity.setDeleteStatus(0l);
            saveEntity.setDateCreated(new Date());
            repository.save(saveEntity);
            return saveEntity.getName();
        }
        else {
            //Updated
            EmployeePeriode fixDateCreated = repository.getById(dto.getId());
            EmployeePeriode updateEntity = dto;
            updateEntity.setDateCreated(fixDateCreated.getDateCreated());
            updateEntity.setDeleteStatus(0l);
            updateEntity.setDateUpdated(new Date());
           repository.save(updateEntity);
            return updateEntity.getName();
        }

        }



    public EmployeePeriode getUpdateDevisi(Long id) {
        EmployeePeriode entity = repository.findById(id).get();
        EmployeePeriode dto = new EmployeePeriode(entity.getId(),
                entity.getName(),
                entity.getJabatan(),
                entity.getNamaDevisi(),
                entity.getPeriode(),
                entity.getStatus())
                ;
        return dto;
    }
}
class EmployeePeriodeRowMapper implements RowMapper<EmployeePeriode> {

    @Override
    public EmployeePeriode mapRow(ResultSet rs, int i) throws SQLException {
        EmployeePeriode rbb = new EmployeePeriode();
        rbb.setId(rs.getLong("ID"));
        rbb.setName(rs.getString("NAMA"));
        rbb.setJabatan(rs.getString("JABATAN"));
        rbb.setNamaDevisi(rs.getString("NAMA_DEVISI"));
        rbb.setPeriode(rs.getString("PERIODE"));
        rbb.setStatus(rs.getString("STATUS"));
        rbb.setDeleteStatus(rs.getLong("DELETE_STATUS"));
        rbb.setDateCreated(rs.getDate("DATE_CREATED"));
        rbb.setDateUpdated(rs.getDate("DATE_UPDATED"));
        rbb.setDateDeleted(rs.getDate("DATE_DELETED"));

        return rbb;
    }
}

