package dev.patika.librarymanagement.business.abstracts;

import dev.patika.librarymanagement.entities.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher save (Publisher publisher);
    Publisher update (Publisher publisher);
    Publisher getById(int id);
    void delete(int id);
    List<Publisher> findAll();
}
