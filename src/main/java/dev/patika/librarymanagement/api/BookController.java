package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.IBookService;
import dev.patika.librarymanagement.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService bookService;

    private ModelMapper modelMapper;


    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return this.bookService.save(book);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book book) {
        return this.bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable("id") Long id) {
        Book book= this.bookService.getById(id);
        return book;
    }
}


