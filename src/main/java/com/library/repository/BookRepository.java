package com.library.repository;

import com.library.dto.book.BookGridDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("""
                SELECT new com.library.dto.book.BookGridDTO(bo.id, bo.title, cat.name, Concat(au.title,'. ', au.firstName,' ', au.lastName), bo.isBorrowed, bo.summary, bo.releaseDate, bo.totalPage)
                FROM Book AS bo
                    JOIN bo.author as au
                    JOIN bo.category as cat
                WHERE bo.authorId = :id """)

    public List<BookGridDTO> findAllBuAuthorId(@Param("id") Long id, Pageable pageable);
    @Query("""
                SELECT new com.library.dto.book.BookGridDTO(bo.id, bo.title, cat.name, Concat(au.title,'. ', au.firstName,' ', au.lastName), bo.isBorrowed, bo.summary, bo.releaseDate, bo.totalPage)
                FROM Book AS bo
                    JOIN bo.author as au
                    JOIN bo.category as cat
                WHERE bo.authorId = :id """)

    public List<BookGridDTO> findAllBuAuthorId(@Param("id") Long id);



    @Query("""
			SELECT new com.library.dto.dropDwonDTO.DropDownDTO(pro.id, pro.title) 
			FROM Book AS pro
			ORDER By pro.id """)
    public List<DropDownDTO> findAllLoanlname();

    @Query("""
                SELECT new com.library.dto.book.BookGridDTO(bo.id, bo.title, cat.name, Concat(au.title,'. ', au.firstName,' ', au.lastName), bo.isBorrowed, bo.summary, bo.releaseDate, bo.totalPage)
                FROM Book AS bo
                    JOIN bo.author as au
                    JOIN bo.category as cat
                WHERE bo.categoryName LIKE %:name%  AND bo.title LIKE %:title%
                AND
                (au.firstName LIKE %:authorName% OR au.lastName LIKE %:authorName%)
                """)

    public List<BookGridDTO> findAllCategoryName(@Param("name") String name,
                                                 @Param("title") String title,
                                                 @Param("authorName") String authorName,
                                                 Pageable pageable);




    @Query("""
                SELECT COUNT (bo.id)
                FROM Book AS bo
                    JOIN bo.author as au
                    JOIN bo.category as cat
                WHERE bo.categoryName LIKE %:categoryName%  AND bo.title LIKE %:title% AND
                (au.firstName LIKE %:authorName% OR au.lastName LIKE %:authorName%)
                """)
    public Long countCategoryName(@Param("categoryName") String categoryName,
                             @Param("title") String title,
                             @Param("authorName") String authorName);


    @Query("""
            SELECT COUNT(cat.id)
            FROM Book AS cat
            WHERE cat.authorId = :id
            """)
    public Long countByAuthorID(@Param("id") Long id);

    @Query("""
            SELECT COUNT(cat.id)
            FROM Book AS cat
            WHERE cat.categoryName = :categoryName
            """)
    public Long countByCategoryID(@Param("categoryName") String categoryName);



}
