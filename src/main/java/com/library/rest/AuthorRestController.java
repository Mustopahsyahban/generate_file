package com.library.rest;

import com.library.dto.author.AuthorGridDTO;
import com.library.dto.author.UpsertAuthorDTO;
import com.library.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorRestController {

    @Autowired
    private AuthorService service;



    @GetMapping
    public ResponseEntity<Object> get(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "") String firstName){
        List<AuthorGridDTO> dtos = service.getAuthorGrid(page, firstName);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody UpsertAuthorDTO dto, BindingResult bindingResult){
        service.saveAuthor(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
    @PostMapping
    public ResponseEntity<Object> post(@RequestBody UpsertAuthorDTO dto, BindingResult bindingResult){
       String respondId = service.saveAuthor(dto);
        dto.setFirstName(respondId);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam(required = true) Long id){
        Boolean success = service.deleteAuthor(id)  ;
        if(success){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(success);
        }
        Long dependentProducts = service.dependentBook(id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dependentProducts);
    }


}
