package dev.patika.librarymanagement.dao;

import dev.patika.librarymanagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book,Integer> {
}
