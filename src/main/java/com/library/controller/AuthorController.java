package com.library.controller;

import com.library.dto.author.AuthorGridDTO;
import com.library.dto.author.UpsertAuthorDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpdateCategoryDTO;
import com.library.dto.category.UpsertCatogoryDTO;
import com.library.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "") String firstName, Model model) {
        List<AuthorGridDTO> grid = service.getAuthorGrid(page, firstName);
        Long totalPage = service.getTotalPages(firstName);
        page = (totalPage > 0) ? page : 0;
        model.addAttribute("grid", grid);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("firstName", firstName);
        return "author/author-index";
    }
    //untuk menampilkan form
    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false) Long id, Model model){
        UpsertAuthorDTO dto = new UpsertAuthorDTO();
        String type = "Insert";
        if(id != null && id!=0){//Edit
            dto = service.getUpdateAuthor(id);
            type = "Update";
        }
        model.addAttribute("author", dto);
        model.addAttribute("type", type);
        return "author/author-form";
    }

    //action untuk menerima data dari form
    @PostMapping("/upsert")
    public String upsert(@Valid @ModelAttribute("author") UpsertAuthorDTO dto,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            String type = "Insert";
            type = (dto.getId() != null && dto.getId()!=0) ? "Update" : type;
            model.addAttribute("type", type);
            return "author/author-form";
        } else {
            service.saveAuthor(dto);
            return "redirect:/author/index";
        }
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(required = true)Long id, Model model){
        var detailGrid = service.getBookDetail(page, id);
        var header = service.getAuthorHeader(id);
        var totalPages = service.getTotalDetailPages(id);
        page = (totalPages > 0) ? page : 0;
        model.addAttribute("detailGrid", detailGrid);
        model.addAttribute("header", header);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        return "author/author-detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Long id, Model model){
        Boolean successDelete = service.deleteAuthor(id);
        if(successDelete){
            return "redirect:/author/index";
        }
        Long totalDependentBooks = service.dependentBook(id);
        model.addAttribute("dependencies", totalDependentBooks);
        return "author/author-delete";
    }


}
