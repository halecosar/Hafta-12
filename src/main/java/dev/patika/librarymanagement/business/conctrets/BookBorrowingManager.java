package dev.patika.librarymanagement.business.conctrets;

import dev.patika.librarymanagement.business.abstracts.IBookBorrowingService;
import dev.patika.librarymanagement.dao.IBookBorrowingRepo;
import dev.patika.librarymanagement.dao.IBookRepo;
import dev.patika.librarymanagement.entities.Book;
import dev.patika.librarymanagement.entities.BookBorrowing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {
    private final IBookBorrowingRepo bookBorrowingRepo;
    private final IBookRepo bookRepo;

    public BookBorrowingManager(IBookBorrowingRepo bookBorrowingRepo, IBookRepo bookRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        Book book = this.bookRepo.findById(bookBorrowing.getBook().getId()).orElseThrow();
        if (book.getStock() > 0) {
            return this.bookBorrowingRepo.save(bookBorrowing);
        } else {
            throw new RuntimeException("Kitabın Stoğu Bulunamamıştır.");
        }

    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowing getById(int id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(int id) {
        this.bookBorrowingRepo.delete(this.getById(id));
    }

    @Override
    public List<BookBorrowing> findAll() {
        return null;
    }
}
