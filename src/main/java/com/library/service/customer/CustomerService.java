package com.library.service.customer;

import com.library.dto.customer.CustomerGridDTO;
import com.library.dto.customer.InsertCustomerDTO;

import java.util.List;

public interface CustomerService {

    public List<CustomerGridDTO> getCustomerGrid(Integer page, String membershipNumber, String fullName);

    public Long getTotalPage(String membershipNumber, String fullName);

    public String saveCustomer(InsertCustomerDTO dto);
    public InsertCustomerDTO getUpdateCustomer(String membershipNumber, String fullName);
    public Boolean deleteCustomer(String membershipNumber);


    public void extendExpireDate(String membershipNumber);
    public Long dependentLoan(String membershipNumber);

}
