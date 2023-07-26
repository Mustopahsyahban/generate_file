package com.library.service.category;

import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;
import com.library.dto.book.BookGridDTO;
import com.library.dto.book.UpsertBookDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.category.UpsertCatogoryDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.entity.Book;
import com.library.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private Integer rowsInPage = 8;

    @Override
    public List<CategoryGridDTO> getCategoryGrid(Integer page, String name) {

        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        List<CategoryGridDTO> grid = repository.findAll(name, pagination);
        for (CategoryGridDTO categoryGridDTO : grid) {
            Long totalBook = bookRepository.countByCategoryID(categoryGridDTO.getName());
            categoryGridDTO.setTotalBook(totalBook);
        }
        return grid;

    }

    @Override
    public Long getTotalPages(String name) {
        double totalData = (double) repository.count(name);
        long totalPages = (long) (Math.ceil(totalData / (double) rowsInPage));
        return totalPages;
    }

    @Override
    public Boolean checkExistingCategoryName(String name) {
        long totalCategoryWithSameName = repository.count(name);
        if (totalCategoryWithSameName > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCategory(UpsertCatogoryDTO dto) {
        Category entity = new Category(dto.getName(),
                dto.getFloor(),
                dto.getIsle(),
                dto.getBay());
        Category categoryBaru = repository.save(entity);
        return categoryBaru.getName();
    }


    @Override
    public UpdateCategoryDTO getUpdateCategory(String name) {
        Category entity = repository.findById(name).get();
        UpdateCategoryDTO dto = new UpdateCategoryDTO(
                entity.getName(),
                entity.getFloor(),
                entity.getIsle(),
                entity.getBay()
        );
        return dto;
    }

    @Override
    public Boolean deleteCategory(String name) {
        Long totalDependentProducts = bookRepository.countByCategoryID(name);
        if (totalDependentProducts == 0) {
            repository.deleteById(name);
            return true;
        }
        return false;
    }

    @Override
    public Long dependentBook(String name) {
        Long totaldependentBook = bookRepository.countByCategoryID(name);
        return totaldependentBook;
    }

    @Override
    public CategoryGridDTO getCategoryHeader(String name) {
        Category entity = repository.findById(name).get();
        CategoryGridDTO header = new CategoryGridDTO(entity.getName(),
                entity.getFloor(),
                entity.getIsle(),
                entity.getBay());
        return header;
    }


    @Override
    public List<BookGridDTO> getBookDetail(Integer page, String name, String title, String authorName) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage);
        List<BookGridDTO> details = bookRepository.findAllCategoryName(name,title,authorName,pagination);
        for (BookGridDTO rows : details) {
            String borrowed = "Available";
            if (rows.getIsBorrowed()) {
                borrowed = "Borrowed";
            }
            rows.setBorrowed(borrowed);
        }
return details;

    }

    @Override
    public Long getTotalDetailPages(String name, String title, String authorName) {
        double totalData = (double) bookRepository.countCategoryName(name, title, authorName);
        long totalPage = (long) (Math.ceil(totalData/(double) rowsInPage));
        return totalPage;
    }

    @Override
    public String saveCategoryDetail(UpsertBookDTO dto) {
        Book entity = new Book(dto.getId(),
                dto.getTitle(),
                dto.getCategoryName(),
                dto.getAuthorId(),
                dto.getIsBorrowed(),
                dto.getSummary(),
                dto.getReleaseDate(),
                dto.getTotalPage());

        Book bookBaru = bookRepository.save(entity);
        return bookBaru.getId();
    }

    @Override
    public List<DropDownDTO> getDropDownAuthor() {
        List<DropDownDTO> dropDownDTOList = authorRepository.findAllDetailname();
        return dropDownDTOList;
    }
}





