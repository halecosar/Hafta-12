package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.ICategoryService;
import dev.patika.librarymanagement.entities.Book;
import dev.patika.librarymanagement.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping("/v1/categories")
    public class CategoryController {
        private final ICategoryService categoryService;

        private ModelMapper modelMapper;


        public CategoryController(ICategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Category save(@RequestBody Category category) {
            return this.categoryService.save(category);
        }


        @PutMapping("/update")
        @ResponseStatus(HttpStatus.OK)
        public Category update(@RequestBody Category category) {
            return this.categoryService.update(category);
        }

        @DeleteMapping("/delete/{id}")
        @ResponseStatus(HttpStatus.OK)
        void delete(@PathVariable("id") int id) {
            this.categoryService.delete(id);
        }

        @GetMapping("/getById/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Category getById(@PathVariable("id") int id) {
            return this.categoryService.getById(id);
        }
    }

