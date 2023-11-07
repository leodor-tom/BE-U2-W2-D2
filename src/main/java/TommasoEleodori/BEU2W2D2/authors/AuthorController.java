package TommasoEleodori.BEU2W2D2.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorServices as;

    @GetMapping
    public List<Author> getAuthors() {
        return as.getAuthors();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id) {
        return as.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int save(@RequestBody Author body) {
        as.save(body);
        return body.getId();
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author body) {
        return as.findByIdAndUpdate(id, body);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String delete() {
        return "When pigs fly!";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        as.findByIdAndDelete(id);
    }
}
