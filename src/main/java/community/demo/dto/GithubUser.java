package community.demo.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private String ACCOUNTID;
    private Long id;
    private String bio;
    private String avatar_url;

}
