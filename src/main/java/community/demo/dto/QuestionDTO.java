package community.demo.dto;

import community.demo.model.Question;
import community.demo.model.User;
import lombok.Data;

@Data
public class QuestionDTO  {
  private User user;
  private  Integer Id;
  private  String Title;
  private  String Descriptions;
  private long Gmt_Create;
  private long Gmt_Modified;
  private String Creat_Name;
  private Integer Communt_Count;
  private Integer view_Count;
  private Integer Like_Count;
  private String Tags;
}
