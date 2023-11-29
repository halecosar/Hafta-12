package dev.patika.librarymanagement.dao;

import dev.patika.librarymanagement.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends JpaRepository<Author,Integer>{
}
