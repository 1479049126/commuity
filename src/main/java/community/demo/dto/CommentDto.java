package community.demo.dto;

import community.demo.model.User;
import lombok.Data;

@Data
public class CommentDto {
    Integer id;
    Integer parentId;
    Integer type;
    String Commentator;
    long GmtCreate;
    long GmtModified;
    Integer LikeCount;
    String description;
    User user;
}
