package com.library.service.priceProduct;

import com.library.repository.ProductPriceRepository;
import com.library.dto.productPrice.ProductPriceGridDTO;
import com.library.dto.productPrice.ProductPriceInsertDTO;
import com.library.dto.productPrice.ProductPriceUpdateDTO;
import com.library.entity.PriceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PriceProductServiceImplementation implements PriceProductService {

    //Pemanggilan Repository
    @Autowired
    private ProductPriceRepository repository;

    //nilai maksimal baris tabel
    private Integer rowsInPage = 8;

    //implementation service
    @Override
    public List<ProductPriceGridDTO> getProductGrid(Integer page, String productName) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        List<ProductPriceGridDTO> grid = repository.findAll(productName, pagination);
        return grid;
    }

    @Override
    public Long getTotalPage(String productName) {
        double totalData = (double) repository.count(productName);
        long totalPages = (long) (Math.ceil(totalData / (double) rowsInPage));
        return totalPages;
    }

    @Override
    public String savePriceProduct(ProductPriceInsertDTO dto) {
        PriceProduct entity = new PriceProduct(dto.getId(),
                dto.getProductName(),
                dto.getProductPrice(),
                dto.getStock(),
                dto.getDesription());
        entity.setDateUpdate(LocalDate.now());
        PriceProduct priceProduct = repository.save(entity);
        return priceProduct.getProductName();
    }

    @Override
    public ProductPriceUpdateDTO getUpdatePriceProduct(Long Id) {
        PriceProduct entity = repository.findById(Id).get();
        entity.setDateUpdate(LocalDate.now());
        ProductPriceUpdateDTO dto = new ProductPriceUpdateDTO(
                entity.getId(),
                entity.getProductName(),
                entity.getProductPrice(),
                entity.getStock(),
                entity.getDescription());
        ;
        return dto;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public void buy(Long id) {
        PriceProduct entity = repository.findById(id).get();
        Long buy = entity.getStock();
        if (buy != null) {
            entity.setDateUpdate(LocalDate.now());
            entity.setStock(buy - 1);
            repository.save(entity);
        }
        else {

        }
    }
}

