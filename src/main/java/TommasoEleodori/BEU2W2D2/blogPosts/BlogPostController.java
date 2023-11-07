package TommasoEleodori.BEU2W2D2.blogPosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService bps;

    @GetMapping
    public List<BlogPost> getAuthors() {
        return bps.getAuthors();
    }

    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return bps.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int save(@RequestBody BlogPost body) {
        bps.save(body);
        return body.getId();
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
        return bps.findByIdAndUpdate(id, body);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String delete() {
        return "When pigs fly!";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        bps.findByIdAndDelete(id);
    }
}
