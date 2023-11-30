package dev.patika.librarymanagement.business.conctrets;

import dev.patika.librarymanagement.business.abstracts.IBookBorrowingService;
import dev.patika.librarymanagement.dao.IBookBorrowingRepo;
import dev.patika.librarymanagement.dao.IBookRepo;
import dev.patika.librarymanagement.entities.BookBorrowing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {
    private final IBookBorrowingRepo bookBorrowingRepo;

    public BookBorrowingManager(IBookRepo bookRepo, IBookBorrowingRepo bookBorrowingRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;

    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
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
