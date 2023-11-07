package TommasoEleodori.BEU2W2D2.blogPosts;

import TommasoEleodori.BEU2W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getAuthors() {
        return this.blogPosts;
    }

    public BlogPost findById(int id) {
        Optional<BlogPost> matchingPost = this.blogPosts.stream()
                .filter(blogPost -> blogPost.getId() == id)
                .findFirst();
        return matchingPost.orElseThrow(() -> new NotFoundException(id));
    }

    public int save(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 300));
        this.blogPosts.add(body);
        return body.getId();
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost body) {
        Optional<BlogPost> foundPostOptional = this.blogPosts.stream()
                .filter(blogPost -> blogPost.getId() == id)
                .findFirst();
        BlogPost found = foundPostOptional.orElseThrow(() -> new NotFoundException(id));

        found.setId(id);
        found.setCategory(body.getCategory());
        found.setCover(body.getCover());
        found.setTitle(body.getTitle());
        found.setContent(body.getContent());
        found.setReadingTime(body.getReadingTime());
        return found;
    }

    public void findByIdAndDelete(int id) {
        this.blogPosts.removeIf(blogPost -> blogPost.getId() == id);
    }
}
