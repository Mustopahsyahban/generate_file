package com.library.service.author;

import com.library.dto.author.AuthorDetailDTO;
import com.library.dto.author.AuthorGridDTO;
import com.library.dto.author.UpsertAuthorDTO;
import com.library.dto.book.BookGridDTO;
import com.library.dto.category.CategoryDetailDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.category.UpsertCatogoryDTO;

import java.util.List;

public interface AuthorService {


    public List<AuthorGridDTO> getAuthorGrid (Integer page, String firstName);
    public Long getTotalPages(String firstName);

    public String saveAuthor(UpsertAuthorDTO dto);
    public UpsertAuthorDTO getUpdateAuthor(Long id);
    public Boolean deleteAuthor(Long id);
    public Long dependentBook(Long id);

    public AuthorGridDTO getAuthorHeader(Long id);
    public List<BookGridDTO> getBookDetail(Integer page, Long id);
    public Long getTotalDetailPages(Long id);

    public AuthorDetailDTO getAuthorWithBook (Long id);
}
