package dev.patika.librarymanagement.business.abstracts;


import dev.patika.librarymanagement.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category save (Category category);
    Category update (Category category);
    Category getById(int id);
    String delete(int id);
    List<Category> findAll();
}
