package com.library.service.category;

import com.library.dto.author.UpsertAuthorDTO;
import com.library.dto.book.BookGridDTO;
import com.library.dto.book.UpsertBookDTO;
import com.library.dto.category.CategoryDetailDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.category.UpsertCatogoryDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryGridDTO> getCategoryGrid(Integer page, String name);

    public Long getTotalPages(String name);

    public Boolean checkExistingCategoryName(String name);

    public String saveCategory(UpsertCatogoryDTO dto);

    public UpdateCategoryDTO getUpdateCategory(String name);

    public Boolean deleteCategory(String name);

    public Long dependentBook(String name);


    public CategoryGridDTO getCategoryHeader(String name);

    public List<BookGridDTO> getBookDetail(Integer page, String name, String title, String authorName);

    public Long getTotalDetailPages(String name, String title, String authorName);

    public String saveCategoryDetail(UpsertBookDTO dto);

    public List<DropDownDTO> getDropDownAuthor();
}

