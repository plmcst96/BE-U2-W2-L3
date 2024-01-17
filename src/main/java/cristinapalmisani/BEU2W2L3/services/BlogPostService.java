package cristinapalmisani.BEU2W2L3.services;

import cristinapalmisani.BEU2W2L3.entities.BlogPost;
import cristinapalmisani.BEU2W2L3.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogPostService {
    private List<BlogPost> blogs = new ArrayList<>();

    public List<BlogPost> getBlog() {
        return this.blogs;
    }

    public BlogPost save(BlogPost body) {
        this.blogs.add(body);
        return body;
    }

    public BlogPost findById(UUID id) {
        BlogPost found = null;
        for (BlogPost user : this.blogs) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(UUID id) {
       Iterator<BlogPost> iterator = this.blogs.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
    }
}

public BlogPost findByIdAndUpdate(UUID id, BlogPost body) {
    BlogPost found = null;
    for (BlogPost blog : blogs) {
        if (blog.getId() == id) {
            found = blog;
            found.setReadingTime(body.getReadingTime());
            found.setCategory(body.getCategory());
            found.setContent(body.getContent());
            found.setCover(body.getCover());
            found.setTitle(body.getTitle());
        }
    }
    if (found == null)
        throw new NotFoundException(id);
    return found;
}
}
