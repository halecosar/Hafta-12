package dev.patika.librarymanagement.dao;

import dev.patika.librarymanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
