package TommasoEleodori.BEU2W2D2.authors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String avatar;
}
