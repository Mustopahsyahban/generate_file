package com.library.service.author;

import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.dto.author.AuthorDetailDTO;
import com.library.dto.author.AuthorGridDTO;
import com.library.dto.author.UpsertAuthorDTO;
import com.library.dto.book.BookGridDTO;
import com.library.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;
    private Integer rowsInPage = 8;

    @Override
    public List<AuthorGridDTO> getAuthorGrid(Integer page, String fistName) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        List<AuthorGridDTO> grid = authorRepository.findAll(fistName, pagination);
        for (AuthorGridDTO rows : grid) {
            Long age;
            if (rows.getDeceasedDate() != null) {
                age = ChronoUnit.YEARS.between(rows.getBirthDate(), rows.getDeceasedDate());
            } else {
                age = ChronoUnit.YEARS.between(rows.getBirthDate(), LocalDate.now());
            }
            rows.setAge(age);
            String status = "Alive";
            if (rows.getDeceasedDate() != null) {
                status = "Deceased";
            }
            rows.setStatus(status);

        }
        return grid;
    }
    @Override
    public Long getTotalPages(String firstName) {
        double totalData = (double) authorRepository.count(firstName);
        long totalPages = (long) (Math.ceil(totalData / (double) rowsInPage));
        return totalPages;
    }

    @Override
    public String saveAuthor(UpsertAuthorDTO dto) {
        Author entity = new Author(dto.getId(),
                dto.getTitle(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getBirthDate(),
                dto.getDeceasedDate(),
                dto.getEducation(),
                dto.getSummary());
        Author authorBaru = authorRepository.save(entity);
        return authorBaru.getFirstName();
    }

    @Override
    public UpsertAuthorDTO getUpdateAuthor(Long id) {
        Author entity = authorRepository.findById(id).get();
        UpsertAuthorDTO dto = new UpsertAuthorDTO(entity.getId(),
                entity.getTitle(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthDate(),
                entity.getDeceasedDate(),
                entity.getEducation(),
                entity.getSummary()
        );
        return dto;
    }

    @Override
    public Boolean deleteAuthor(Long id) {
        Long totalDependentProducts = bookRepository.countByAuthorID(id);
        if(totalDependentProducts == 0){
            authorRepository.deleteById(id);
            return true ;
        }
        return false ;
    }

    @Override
    public Long dependentBook(Long id) {
        Long totaldependentBook = bookRepository.countByAuthorID(id);
        return totaldependentBook;
    }

    @Override
    public AuthorGridDTO getAuthorHeader(Long id) {
        Author entity = authorRepository.findById(id).get();
        String fullName=String.format(" %s %s",entity.getFirstName(),entity.getLastName() );
        AuthorGridDTO header = new AuthorGridDTO(
                entity.getId(),
                entity.getTitle(),
                fullName,
                entity.getBirthDate(),
                entity.getDeceasedDate(),
                entity.getEducation(),
                entity.getSummary()
        );
        return header ;
    }

    @Override
    public List<BookGridDTO> getBookDetail(Integer page, Long id) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        List<BookGridDTO> details = bookRepository.findAllBuAuthorId(id, pagination);
        return details ;
    }

    @Override
    public Long getTotalDetailPages(Long id) {
        double totalData = (double) bookRepository.countByAuthorID(id);
        long totalPages =(long) (Math.ceil(totalData/(double) rowsInPage));
        return totalPages;
    }

    @Override
    public AuthorDetailDTO getAuthorWithBook(Long id) {
        AuthorGridDTO author = getAuthorHeader(id);//data makanan
        List<BookGridDTO> books = bookRepository.findAllBuAuthorId(id); //produk produk makanannya
        AuthorDetailDTO detail = new AuthorDetailDTO(author,books); //ini pake constraktor
        return detail;
    }
}
