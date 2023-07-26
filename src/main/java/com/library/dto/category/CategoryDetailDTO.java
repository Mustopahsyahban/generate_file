package com.library.dto.category;

import com.library.dto.book.BookGridDTO;
import com.library.entity.Book;
import com.library.entity.Category;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CategoryDetailDTO {

    @Getter @Setter private CategoryGridDTO category;
    @Getter @Setter private List<BookGridDTO> books;

}
