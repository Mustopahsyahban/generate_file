package com.library.repository;

import com.library.dto.book.BookGridDTO;
import com.library.entity.NasabahMstEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NasabahMstRepository extends JpaRepository<NasabahMstEntity,Integer> {

    List <NasabahMstEntity> findByIdCustomer (String idCustomer);


}
