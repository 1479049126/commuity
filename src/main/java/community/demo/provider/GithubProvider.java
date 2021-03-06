package community.demo.provider;

import com.alibaba.fastjson.JSON;
import community.demo.dto.AccessTokenDto;
import community.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Component

public class GithubProvider {
    @Autowired
    private GithubParams githubParams;

    /**
     * 获取AccessToken
     */
    public String getAccessToken(AccessTokenDto accessTokenDto) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //将accessTokenDto转为json字符串传入参数
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url(githubParams.getToken_uri())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();

            //得到的是类似这样的字符串，我们需要将它分割，只要access_token部分
            //access_token=9566ba3483a556c610be42d44338f3fd16a3b8d1&scope=&token_type=bearer
            return str.split("&")[0].split("=")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据access_token获取用户信息
     */
    public GithubUser getGithubUser(String access_token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + access_token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            //得到的是json字符串，因此需要转为GithubUser对象
            GithubUser githubUser= JSON.parseObject(response.body().string(), GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
