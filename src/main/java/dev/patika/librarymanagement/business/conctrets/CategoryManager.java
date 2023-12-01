package dev.patika.librarymanagement.business.conctrets;

import dev.patika.librarymanagement.business.abstracts.ICategoryService;
import dev.patika.librarymanagement.dao.IBookBorrowingRepo;
import dev.patika.librarymanagement.dao.IBookRepo;
import dev.patika.librarymanagement.dao.ICategoryRepo;
import dev.patika.librarymanagement.entities.BookBorrowing;
import dev.patika.librarymanagement.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {
    private final ICategoryRepo categoryRepo;

    public CategoryManager(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category getById(int id) {
        return this.categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public String delete(int id) { //Kategori silme işlemi
        Category category = this.categoryRepo.findById(id).orElseThrow();
        if (category!=null  && category.getBookList().size()>0){
             return "Bu Kategoriye Ait Kitaplar Olduğu İçin Silme İşlemi Yapılamaz.";
        }
        else{
            this.categoryRepo.delete(this.getById(id));
            return "Silme İşlemi Başarlı";
        }

    }


    @Override
    public List<Category> findAll() {
        return null;
    }
}


