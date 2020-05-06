package community.demo.dto;

import lombok.Data;

@Data
public class CommentCreatDTO {
    private Integer parentId;
    private String description;
    private Integer type;
}
