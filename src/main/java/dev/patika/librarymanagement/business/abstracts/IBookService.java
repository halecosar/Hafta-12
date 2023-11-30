package dev.patika.librarymanagement.business.abstracts;

import dev.patika.librarymanagement.entities.Book;


import java.util.List;

public interface IBookService {

    Book save (Book book);
    Book update (Book book);
    Book getById(Long id);
    void delete(Long id);
    List<Book> findAll();
}
