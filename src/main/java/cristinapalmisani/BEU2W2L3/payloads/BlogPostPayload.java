package cristinapalmisani.BEU2W2L3.payloads;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter

public class BlogPostPayload {
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    private UUID authorId;

    public String getCover() {
        return cover = "https://picsum.photos/200/300";
    }
}
