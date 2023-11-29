package dev.patika.librarymanagement.dao;

import dev.patika.librarymanagement.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
