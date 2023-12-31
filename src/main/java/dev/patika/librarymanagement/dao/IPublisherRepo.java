package dev.patika.librarymanagement.dao;

import dev.patika.librarymanagement.entities.Publisher;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublisherRepo extends JpaRepository<Publisher,Long> {
}
