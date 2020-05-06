package community.demo.model;

import lombok.Data;


@Data
public class Question {
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
