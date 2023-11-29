package dev.patika.librarymanagement.business.conctrets;

import dev.patika.librarymanagement.business.abstracts.IAuthorService;
import dev.patika.librarymanagement.dao.IAuthorRepo;
import dev.patika.librarymanagement.dao.IBookRepo;
import dev.patika.librarymanagement.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorManager implements IAuthorService {
    private final IAuthorRepo iAuthorRepo; //dependency injection


    public AuthorManager(IAuthorRepo iAuthorRepo) {
        this.iAuthorRepo = iAuthorRepo;

    }

    @Override
    public Author save(Author author) {

        return this.iAuthorRepo.save(author); //yazar kayıt etme işlemi.
    }

    @Override
    public Author update(Author author) {
        return this.iAuthorRepo.save(author);
    }

    @Override
    public Author getById(int id) {
        return this.iAuthorRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(int id) {
        this.iAuthorRepo.deleteById(id);

    }

    @Override
    public List<Author> findAll() {
        return this.iAuthorRepo.findAll();
    }
}
