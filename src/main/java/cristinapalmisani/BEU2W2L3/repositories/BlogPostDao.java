package cristinapalmisani.BEU2W2L3.repositories;

import cristinapalmisani.BEU2W2L3.entities.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogPostDao extends JpaRepository<BlogPost, UUID> {
    Page<BlogPost> getBlogPostsByAuthorId(UUID id, Pageable pageable);
}
