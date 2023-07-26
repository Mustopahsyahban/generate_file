package com.library.repository;

import com.library.dto.author.AuthorGridDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("""
                SELECT new com.library.dto.author.AuthorGridDTO(cat.id, cat.title, CONCAT(cat.firstName,' ', cat.lastName), cat.birthDate, cat.deceasedDate, cat.education, cat.summary)
                FROM Author AS cat
                WHERE cat.firstName LIKE %:firstName%
           """)

    public List<AuthorGridDTO> findAll(@Param("firstName") String firstName, Pageable pageable);


    @Query("""
            SELECT COUNT(cat.id)
            FROM Author AS cat
            WHERE cat.firstName LIKE %:firstName%""")
    public Long count(@Param("firstName") String firstName);

    @Query("""
			SELECT new com.library.dto.dropDwonDTO.DropDownDTO(pro.id, CONCAT(pro.firstName,' ', pro.lastName)) 
			FROM Author AS pro
			ORDER By pro.id """)
    public List<DropDownDTO> findAllDetailname();
}
