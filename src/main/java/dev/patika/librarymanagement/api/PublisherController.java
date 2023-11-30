package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.IPublisherService;
import dev.patika.librarymanagement.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/v1/publishers")
    public class PublisherController {
        private final IPublisherService publisherService;

        private ModelMapper modelMapper;

        public PublisherController(IPublisherService publisherService) {
            this.publisherService = publisherService;
        }

        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Publisher save(@RequestBody Publisher publisher) {
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

