package dev.patika.librarymanagement.business.abstracts;


import dev.patika.librarymanagement.dto.response.BookBorrowingUpdateResponse;
import dev.patika.librarymanagement.entities.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing save (BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    BookBorrowing getById(Long id);
    void delete(Long id);
    List<BookBorrowing> findAll();
}
