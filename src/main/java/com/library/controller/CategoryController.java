package com.library.controller;

import com.library.dto.book.UpsertBookDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.category.UpsertCatogoryDTO;
import com.library.dto.dropDwonDTO.DropDownDTO;
import com.library.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "") String name, Model model) {
        List<CategoryGridDTO> grid = service.getCategoryGrid(page, name);
        Long totalPage = service.getTotalPages(name);
        page = (totalPage > 0) ? page : 0;
        model.addAttribute("grid", grid);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("name", name);
        return "category/category-index";
    }

    //untuk menampilkan form
    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false) String name, Model model){

        UpdateCategoryDTO dto1 = new UpdateCategoryDTO();
        String actionType = "Insert";
        if(name != null){//Edit
            dto1 = service.getUpdateCategory(name);
            actionType = "Update";
        }
        model.addAttribute("category", dto1);
        model.addAttribute("type", actionType);
        return "category/category-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("category") UpsertCatogoryDTO dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getName() != null) ? "Update" : type;
            model.addAttribute("type", type);
            return "category/category-form";
        } else {
            service.saveCategory(dto);
            return "redirect:/category/index";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)String name, Model model){
        Boolean successDelete = service.deleteCategory(name);
        if(successDelete){
            return "redirect:/category/index";
        }
        Long totalDependentBooks = service.dependentBook(name);
        model.addAttribute("dependencies", totalDependentBooks);
        return "category/category-delete";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(required = true)String name,
                         @RequestParam(defaultValue ="" )String title,
                         @RequestParam(defaultValue ="" )String authorName,
                         Model model){
        var detailGrid = service.getBookDetail(page, name, title, authorName);
        var header = service.getCategoryHeader(name);
        var totalPages = service.getTotalDetailPages(name, title, authorName);
        page = (totalPages > 0) ? page : 0;
        model.addAttribute("detailGrid", detailGrid);
        model.addAttribute("header", header);
        model.addAttribute("title", title);
        model.addAttribute("authorName", authorName);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        return "category/category-detail";
    }
    @GetMapping("/detail/upsertFormDetail")
    public String upsertFormDetail(@RequestParam(required = false) String name, Model model){
        UpsertBookDTO dto = new UpsertBookDTO();
        List<DropDownDTO> authorDropDwon = service.getDropDownAuthor();
        dto.setCategoryName(name);
        String actionType = "Insert";
        model.addAttribute("authorDropDown",authorDropDwon);
        model.addAttribute("book", dto);
        model.addAttribute("type", actionType);
        return "category/category-insertDetailForm";
    }


}

