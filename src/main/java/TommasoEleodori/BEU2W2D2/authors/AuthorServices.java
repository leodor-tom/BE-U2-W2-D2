package TommasoEleodori.BEU2W2D2.authors;

import TommasoEleodori.BEU2W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthorServices {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author findById(int id) {
        Optional<Author> matchingAuthor = this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst();
        return matchingAuthor.orElseThrow(() -> new NotFoundException(id));
    }

    public int save(Author body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 300));
        body.setAvatar(body.getName() + "_" + body.getSurname());
        this.authors.add(body);
        return body.getId();
    }

    public Author findByIdAndUpdate(int id, Author body) {
        Optional<Author> foundUserOptional = this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst();
        Author found = foundUserOptional.orElseThrow(() -> new NotFoundException(id));

        found.setId(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setBirthDate(body.getBirthDate());
        found.setAvatar(body.getName() + "_" + body.getSurname());
        return found;
    }

    public void findByIdAndDelete(int id) {
        this.authors.removeIf(author -> author.getId() == id);
    }
}
