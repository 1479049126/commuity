package community.demo.model;

import lombok.Data;

import java.math.BigInteger;
@Data
public class User {
    private Integer id;
    private String name;
    private  String accountId;
    private String token;
    private String Avatar_Url;
    private long gmtCreate;
    private long gmtModified;
    private String password;
}
