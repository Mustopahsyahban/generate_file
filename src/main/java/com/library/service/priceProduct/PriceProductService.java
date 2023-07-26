package com.library.service.priceProduct;

import com.library.dto.customer.InsertCustomerDTO;
import com.library.dto.productPrice.ProductPriceGridDTO;
import com.library.dto.productPrice.ProductPriceInsertDTO;
import com.library.dto.productPrice.ProductPriceUpdateDTO;

import java.util.List;

public interface PriceProductService {

    public List<ProductPriceGridDTO> getProductGrid(Integer page, String productName);

    public Long getTotalPage(String productName);

    public String savePriceProduct(ProductPriceInsertDTO dto);

    public ProductPriceUpdateDTO getUpdatePriceProduct(Long Id);


    public Boolean deleteProduct(Long id);


    public void buy(Long id);

}
