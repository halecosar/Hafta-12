package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.IBookBorrowingService;
import dev.patika.librarymanagement.core.config.modelMapper.IModelMapperService;
import dev.patika.librarymanagement.dto.request.BookBorrowingUpdateRequest;
import dev.patika.librarymanagement.dto.response.BookBorrowingUpdateResponse;
import dev.patika.librarymanagement.entities.BookBorrowing;
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
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowingUpdateResponse update(@RequestBody BookBorrowingUpdateRequest bookBorrowingupdateRequest) {
        BookBorrowing baseBookBorrowing = this.bookBorrowingService.getById(bookBorrowingupdateRequest.getId());
        if (baseBookBorrowing!= null){
            baseBookBorrowing.setBorrowerName(bookBorrowingupdateRequest.getBorrowerName());
            baseBookBorrowing.setBorrowingDate(bookBorrowingupdateRequest.getBorrowingDate());
            baseBookBorrowing.getBook().setId(bookBorrowingupdateRequest.getBookId());

            this.bookBorrowingService.update(baseBookBorrowing);

            BookBorrowingUpdateResponse bookBorrowingUpdateResponse = this.modelMapperService.forResponse().map(baseBookBorrowing, BookBorrowingUpdateResponse.class);
            return bookBorrowingUpdateResponse;
        }
        else {
            return null;
        }

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing) {
        return this.bookBorrowingService.save(bookBorrowing);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") int id) {
        this.bookBorrowingService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing getById(@PathVariable("id") int id) {
        return this.bookBorrowingService.getById(id);
    }


}

