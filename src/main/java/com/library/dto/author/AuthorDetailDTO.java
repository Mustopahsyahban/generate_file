package com.library.dto.author;

import com.library.dto.book.BookGridDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AuthorDetailDTO {

    @Getter @Setter private AuthorGridDTO author;
    @Getter @Setter private List<BookGridDTO> books;
}
