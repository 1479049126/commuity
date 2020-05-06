package community.demo.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

@ConfigurationProperties(prefix = "github")
public class GithubParams {

    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String token_uri;
    private String user_uri;
    //省略getter setter

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public void setToken_uri(String token_uri) {
        this.token_uri = token_uri;
    }

    public void setUser_uri(String user_uri) {
        this.user_uri = user_uri;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public String getToken_uri() {
        return token_uri;
    }

    public String getUser_uri() {
        return user_uri;
    }
}