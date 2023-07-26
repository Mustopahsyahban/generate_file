package com.library.service.loan;

import com.library.repository.BookRepository;
import com.library.repository.CustomerRepository;
import com.library.repository.LoanRepository;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.dto.loan.InsertLoanDTO;
import com.library.dto.loan.LoanGridDTO;
import com.library.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanServiceImplementation implements LoanService{


    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    private Integer rowsInPage = 8;


    @Override
    public List<LoanGridDTO> getLoanGrid(Integer page, String membershipNumber,String title) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        List<LoanGridDTO> grid = loanRepository.findAll(membershipNumber,title, pagination);
        return grid;

    }

    @Override
    public String saveLoan(InsertLoanDTO dto) {
        Loan entity = new Loan(dto.getId(),
                dto.getCustomerNumber(),
                dto.getBookCode(),
                dto.getLoanDate(),
                dto.getDueDate(),
                dto.getReturnDate(),
                dto.getNote());
        Loan loanBaru = loanRepository.save(entity);
        return loanBaru.getBookCode();
    }

    @Override
    public Long getTotalPage(String membershipNumber, String title) {
        double totalData = (double) loanRepository.count(membershipNumber, title);
        long totalPages = (long) (Math.ceil(totalData / (double) rowsInPage));
        return totalPages;
    }

    @Override
    public void returnDate(Long id) {
        Loan entity = loanRepository.findById(id).get();
        LocalDate returnDate = entity.getReturnDate();
        entity.setReturnDate(LocalDate.now());
        loanRepository.save(entity);
    }

    @Override
    public List<DropDownDTO> getDropDownBook() {
        List<DropDownDTO> dropDownDTOList = bookRepository.findAllLoanlname();
        return dropDownDTOList;
    }

    @Override
    public List<DropDownDTO> getDropDownCustomer() {
        List<DropDownDTO> dropDownDTOList = customerRepository.findAllLoan();
        return dropDownDTOList;
    }

    @Override
    public InsertLoanDTO getUpdateLoan(String membershipNumber, String title) {
        return null;
    }
}

