package dev.patika.librarymanagement.business.conctrets;

import dev.patika.librarymanagement.business.abstracts.IPublisherService;
import dev.patika.librarymanagement.dao.IPublisherRepo;
import dev.patika.librarymanagement.entities.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherManager implements IPublisherService {
    private final IPublisherRepo publisherRepo;

    public PublisherManager(IPublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher getById(int id) {
        return this.publisherRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(int id) {
        this.publisherRepo.delete(this.getById(id));
    }

    @Override
    public List<Publisher> findAll() {
        return null;
    }
}
