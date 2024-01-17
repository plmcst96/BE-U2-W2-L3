package cristinapalmisani.BEU2W2L3.controllers;

import cristinapalmisani.BEU2W2L3.entities.Author;
import cristinapalmisani.BEU2W2L3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    // GET lista autori
    @GetMapping
    public Page<Author> getAuthor(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String orderBy){
        return authorService.getAuthor(page, size, orderBy);
    }

    // GET singolo autore
    @GetMapping("/{id}")
    public Author findById(@PathVariable UUID id) {
        return authorService.findById(id);
    }

    // POST nuovo autore
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveBlog(@RequestBody Author body) {
        return authorService.save(body);
    }

    //PUT modifica il autore
    @PutMapping("/{id}")
    public Author findByAndUpdate(@PathVariable UUID id, @RequestBody Author body) {
        return this.authorService.findByIdAndUpdate(id, body);}

    //DELETE elimina autore

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        this.authorService.findByIdAndDelete(id);
    }
}
