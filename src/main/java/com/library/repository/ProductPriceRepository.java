package com.library.repository;

import com.library.dto.productPrice.ProductPriceGridDTO;
import com.library.entity.PriceProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface ProductPriceRepository extends JpaRepository<PriceProduct, Long> {
    @Query("""
                SELECT new com.library.dto.productPrice.ProductPriceGridDTO(pri.id, pri.productName, pri.productPrice, pri.stock , pri.dateUpdate)
                FROM PriceProduct AS pri
                WHERE pri.productName LIKE %:productName%
           """)

    public List<ProductPriceGridDTO> findAll(@Param("productName") String productName,Pageable pageable);


    @Query("""
            SELECT COUNT(cus.productName)
            FROM PriceProduct AS cus
                WHERE cus.productName LIKE %:productName%
            """)
    public Long count(@Param("productName") String productName);

}
