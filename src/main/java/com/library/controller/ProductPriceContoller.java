package com.library.controller;

import com.library.dto.customer.InsertCustomerDTO;
import com.library.dto.loan.LoanGridDTO;
import com.library.dto.productPrice.ProductPriceGridDTO;
import com.library.dto.productPrice.ProductPriceInsertDTO;
import com.library.dto.productPrice.ProductPriceUpdateDTO;
import com.library.entity.PriceProduct;
import com.library.service.priceProduct.PriceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/priceProduct")
public class ProductPriceContoller {

    @Autowired
    private PriceProductService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "") String productName,Model model) {
        List<ProductPriceGridDTO> grid = service.getProductGrid(page, productName);
        Long totalPage = service.getTotalPage(productName );
        page = (totalPage > 0) ? page : 0;
        model.addAttribute("grid", grid);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("productName", productName);
        return "priceProduct/priceProduct-index";
    }

    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Long id,String productName, Model model){
        ProductPriceUpdateDTO dto = new ProductPriceUpdateDTO();
        String actionType = "Insert";
        if(id != null){//Edit
            dto = service.getUpdatePriceProduct(id);
            actionType = "Update";
        }
        model.addAttribute("priceProduct", dto);
        model.addAttribute("type", actionType);
        return "priceProduct/priceProduct-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("priceProduct") ProductPriceInsertDTO dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "priceProduct/priceEmployee-form";
        } else {
            service.savePriceProduct(dto);
            return "redirect:/priceProduct/index";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Long id, Model model) {
        Boolean successDelete = service.deleteProduct(id);
            return "redirect:/priceProduct/index";
        }

    @GetMapping("/return")
    public String extend(@RequestParam(required = true) Long id, Model model) {
        service.buy(id);
        return "redirect:/priceProduct/index";
    }
    }
