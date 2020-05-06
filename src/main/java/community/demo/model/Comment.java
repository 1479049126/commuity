package community.demo.model;

import lombok.Data;

@Data
public class Comment {
    Integer id;
    Integer parentid;
    Integer Type;
    String Commentator;
    long GmtCreate;
    long GmtModified;
    Integer LikeCount;
    String Description;
}
