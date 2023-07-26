package com.library.service.customer;

import com.library.repository.CustomerRepository;
import com.library.repository.LoanRepository;
import com.library.dto.customer.CustomerGridDTO;
import com.library.dto.customer.InsertCustomerDTO;
import com.library.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository loanRepository;

    private Integer rowsInPage = 8;

    @Override
    public List<CustomerGridDTO> getCustomerGrid(Integer page, String membershipNumber, String fullName) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        List<CustomerGridDTO> grid = customerRepository.findAll(membershipNumber,fullName, pagination);
        return grid;

    }

    @Override
    public Long getTotalPage(String membershipNumber, String fullName) {
        double totalData = (double) customerRepository.count(membershipNumber,fullName);
        long totalPages = (long) (Math.ceil(totalData / (double) rowsInPage));
        return totalPages;
    }

    @Override
    public String saveCustomer(InsertCustomerDTO dto) {
        Customer entity = new Customer(dto.getMembershipNumber(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getBirthDate(),
                dto.getGender(),
                dto.getPhone(),
                dto.getAddress(),
                dto.getMembershipExpireDate());
        Customer customerBaru = customerRepository.save(entity);
        return customerBaru.getMembershipNumber();
    }

    @Override
    public InsertCustomerDTO getUpdateCustomer(String membershipNumber, String fullName) {
        Customer entity = customerRepository.findById(membershipNumber).get();
        InsertCustomerDTO dto = new InsertCustomerDTO(
                entity.getMembershipNumber(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthDate(),
                entity.getGender(),
                entity.getPhone(),
                entity.getAddress(),
                entity.getMembershipExpireDate()
        );
        return dto;
    }

    @Override
    public Boolean deleteCustomer(String membershipNumber) {
        Long totalDependentLoan = loanRepository.countByCustomerNumber(membershipNumber);
        if (totalDependentLoan == 0) {
            customerRepository.deleteById(membershipNumber);
            return true;
        }
        return false;
    }


    @Override
    public void extendExpireDate(String membershipNumber) {
        Customer entity = customerRepository.findById(membershipNumber).get();
        LocalDate expireDate = entity.getMembershipExpireDate();
        entity.setMembershipExpireDate(expireDate.plusYears(2));
        customerRepository.save(entity);
    }

    @Override
    public Long dependentLoan(String membershipNumber) {
        Long totaldependentLoan = loanRepository.countByCustomerNumber(membershipNumber);
        return totaldependentLoan;
    }
}


