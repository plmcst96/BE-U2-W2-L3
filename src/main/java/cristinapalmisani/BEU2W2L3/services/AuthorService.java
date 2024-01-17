package cristinapalmisani.BEU2W2L3.services;

import cristinapalmisani.BEU2W2L3.entities.Author;
import cristinapalmisani.BEU2W2L3.exception.NotFoundException;
import cristinapalmisani.BEU2W2L3.repositories.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public Page<Author> getAuthor(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return authorDao.findAll(pageable);
    }

    public Author save(Author body) {
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        return authorDao.save(body);
    }

    public Author findById(UUID id) {
        return authorDao.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Author found = this.findById(id);
        authorDao.delete(found);
    }
    public Author findByIdAndUpdate(UUID id, Author body) {
        Author found = this.findById(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setBirthDate(body.getBirthDate());
        found.setEmail(body.getEmail());
        return authorDao.save(found);
    }
}
