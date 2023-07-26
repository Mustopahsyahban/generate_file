package com.library.rest;

import com.library.dto.author.AuthorGridDTO;
import com.library.dto.author.UpsertAuthorDTO;
import com.library.dto.category.CategoryGridDTO;
import com.library.dto.category.UpsertCatogoryDTO;
import com.library.entity.Category;
import com.library.service.author.AuthorService;
import com.library.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryRestController {

    @Autowired
    private CategoryService service;



    @GetMapping
    public ResponseEntity<Object> get(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "") String name){
        List<CategoryGridDTO> dtos = service.getCategoryGrid(page, name);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody UpsertCatogoryDTO dto){
        service.saveCategory(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
    @PostMapping
    public ResponseEntity<Object> post(@RequestBody UpsertCatogoryDTO dto){
        String respondId = service.saveCategory(dto);
        dto.setName(respondId);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam(required = true) String name){
        Boolean success = service.deleteCategory(name)  ;
        if(success){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(success);
        }
        Long dependentProducts = service.dependentBook(name);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dependentProducts);
    }
}