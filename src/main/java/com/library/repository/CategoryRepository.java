package com.library.repository;

import com.library.dto.category.CategoryGridDTO;
import com.library.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, String> {


    @Query("""
                SELECT new com.library.dto.category.CategoryGridDTO(cat.name, cat.floor, cat.isle, cat.bay)
                FROM Category AS cat
                WHERE cat.name LIKE %:name%
           """)

    public List<CategoryGridDTO> findAll(@Param("name") String name, Pageable pageable);

    @Query("""
            SELECT COUNT(cat.name)
            FROM Category AS cat
            WHERE cat.name LIKE %:name%
            """)
    public Long count(@Param("name") String name);

}
