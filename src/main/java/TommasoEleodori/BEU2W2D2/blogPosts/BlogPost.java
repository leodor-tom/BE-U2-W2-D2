package TommasoEleodori.BEU2W2D2.blogPosts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogPost {
    private int id;
    private String category;
    private String title;
    private String cover = "https://picsum.photos/200/300";
    private String content;
    private long readingTime;
}
