package com.library.service.loan;

import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.customer.CustomerGridDTO;
import com.library.dto.customer.InsertCustomerDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.dto.loan.InsertLoanDTO;
import com.library.dto.loan.LoanGridDTO;

import java.util.List;

public interface LoanService {

    public List<LoanGridDTO> getLoanGrid(Integer page, String membershipNumber, String title);
    public String saveLoan(InsertLoanDTO dto);
    public Long getTotalPage(String membershipNumber, String title);
    public void returnDate(Long id);

    List<DropDownDTO> getDropDownCustomer();
    List<DropDownDTO> getDropDownBook();

    public InsertLoanDTO getUpdateLoan(String membershipNumber, String title);

}
