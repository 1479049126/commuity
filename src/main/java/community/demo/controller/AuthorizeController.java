package community.demo.controller;

import community.demo.Service.UserService;
import community.demo.dto.AccessTokenDto;
import community.demo.dto.GithubUser;
import community.demo.mapper.UserMapper;
import community.demo.model.User;
import community.demo.provider.GithubParams;
import community.demo.provider.GithubProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller

public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private GithubParams githubParams;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request, HttpServletResponse response){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(githubParams.getClient_id());
        accessTokenDto.setClient_secret(githubParams.getClient_secret());
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(githubParams.getRedirect_uri());
        accessTokenDto.setState(state);
        //获取access_token
        String access_token = githubProvider.getAccessToken(accessTokenDto);
        //根据accessToken获取用户信息
        GithubUser githubUser = githubProvider.getGithubUser(access_token);
        System.out.print(githubUser);
        if(githubUser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatar_Url(githubUser.getAvatar_url());
            userService.findDBuser(user);
            response.addCookie(new Cookie("token",token));
            request.getSession().setAttribute("user",user);
            return "redirect:/";
            //登录成功
            //给的是路径
        }
        else{
            return "redirect:/";
            //登录失败
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
            request.getSession().removeAttribute("user");
            Cookie cookie = new Cookie("token",null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
       return "redirect:/";
    }
}
