package cristinapalmisani.BEU2W2L3.controllers;

import cristinapalmisani.BEU2W2L3.entities.BlogPost;
import cristinapalmisani.BEU2W2L3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    // GET lista blog
    @GetMapping
    public Page<BlogPost> getBlog(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String orderBy){
        return blogPostService.getBlog(page, size, orderBy);
    }

    // GET singolo blog
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable UUID id) {
        return blogPostService.findById(id);
    }

    // POST nuovo blog
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlog(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    //PUT modifica il blogPost
    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable UUID id, @RequestBody BlogPost body) {
        return this.blogPostService.findByIdAndUpdate(id, body);}

    //DELETE elimina post
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        this.blogPostService.findByIdAndDelete(id);
    }

    @GetMapping("author/{id}")
    public Page<BlogPost> getBlogPostsByAuthorId(@PathVariable int id,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "id") String sort) {
        return blogPostService.getBlogPostsByAuthorId(id, page, size, sort);
    }


}
