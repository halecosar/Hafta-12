package dev.patika.librarymanagement.api;

import dev.patika.librarymanagement.business.abstracts.IAuthorService;
import dev.patika.librarymanagement.dao.IAuthorRepo;
import dev.patika.librarymanagement.entities.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private final IAuthorService authorService; //business katmanına ihtiyacımız var.
   // @Autowired
   // private ModelMapper modelMapper;

    public AuthorController(IAuthorService authorService, IAuthorRepo authorRepo) {
        this.authorService = authorService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author) { //entitiy'i gönderdik.
        // Author author1 = this.modelMapper.map(author, Author.class); //entitiydeki propertyler ile dtodak ropertyleri mapleme işlemi
        return this.authorService.save(author);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Author update (@RequestBody Author author) {
        return this.authorService.update(author);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.authorService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getById(@PathVariable("id") Long id) {
       return this.authorService.getById(id);
    }
}
