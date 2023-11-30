package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.IPublisherService;
import dev.patika.librarymanagement.core.config.modelMapper.IModelMapperService;
import dev.patika.librarymanagement.dto.request.PublisherSaveRequest;
import dev.patika.librarymanagement.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final IPublisherService publisherService;
    private final IModelMapperService modelMapperService;

    public PublisherController(IPublisherService publisherService, IModelMapperService modelMapperService) {
        this.publisherService = publisherService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest) {
        Publisher publisher = this.modelMapperService.forRequest().map(publisherSaveRequest, Publisher.class);
        return this.publisherService.save(publisher);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@RequestBody Publisher publisher) {
        return this.publisherService.update(publisher);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") int id) {
        this.publisherService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getById(@PathVariable("id") int id) {
        return this.publisherService.getById(id);
    }
}

