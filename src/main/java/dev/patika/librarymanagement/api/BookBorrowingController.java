package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.IBookBorrowingService;
import dev.patika.librarymanagement.core.config.modelMapper.IModelMapperService;
import dev.patika.librarymanagement.dto.request.BookBorrowingUpdateRequest;
import dev.patika.librarymanagement.dto.response.BookBorrowingUpdateResponse;
import dev.patika.librarymanagement.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookborrowings")
public class BookBorrowingController {

    @Autowired
    private final IBookBorrowingService bookBorrowingService;
    private final IModelMapperService modelMapperService;

    @Autowired
    public BookBorrowingController(IBookBorrowingService bookBorrowingService, IModelMapperService modelMapperService) {
        this.bookBorrowingService = bookBorrowingService;
        this.modelMapperService = modelMapperService;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK) //e-mail girişi olmayacak şekilde Request ve response dto kullanıldı.Maplendi.
    public BookBorrowingUpdateResponse update(@Valid @RequestBody BookBorrowingUpdateRequest bookBorrowingupdateRequest) {

        BookBorrowing bookBorrowing = this.modelMapperService.forRequest().map(bookBorrowingupdateRequest, BookBorrowing.class);
        BookBorrowing baseBookBorowing = this.bookBorrowingService.getById(bookBorrowingupdateRequest.getId());
        bookBorrowing.setBorrowerMail(baseBookBorowing.getBorrowerMail());
        bookBorrowing.setBorrowingDate(baseBookBorowing.getBorrowingDate());

        this.bookBorrowingService.update(bookBorrowing);

        BookBorrowingUpdateResponse bookBorrowingUpdateResponse = this.modelMapperService.forResponse().map(bookBorrowing, BookBorrowingUpdateResponse.class);
        return bookBorrowingUpdateResponse;


    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing) {
        return this.bookBorrowingService.save(bookBorrowing);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") Long id) {
        this.bookBorrowingService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing getById(@PathVariable("id") Long id) {
        return this.bookBorrowingService.getById(id);
    }


}

