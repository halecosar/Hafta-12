package dev.patika.librarymanagement.business.conctrets;

import dev.patika.librarymanagement.business.abstracts.IBookService;
import dev.patika.librarymanagement.dao.IBookRepo;
import dev.patika.librarymanagement.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {

    private final IBookRepo iBookRepo; //dependency injection

    public BookManager(IBookRepo iBookRepo) {
        this.iBookRepo = iBookRepo;
    }

    @Override
    public Book save(Book book) {
        return this.iBookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        return this.iBookRepo.save(book);
    }

    @Override
    public Book getById(int id) {
        return this.iBookRepo.getById(id);
    }

    @Override
    public void delete(int id) {
        this.iBookRepo.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
