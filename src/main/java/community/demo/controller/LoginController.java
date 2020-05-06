package community.demo.controller;

import community.demo.Service.LoginService;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }
    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name ="password") String password,
                        HttpServletRequest request,
                        Model model){
        User user = new User();
        user.setAccountId(email);

        user.setPassword(password);
        if (email!=null&&password!=null){
            boolean flag = loginService.findUser(user);

            if (flag){
                //token的设置？
                user.setName(loginService.findName(user));
                request.getSession().setAttribute("user",user);
                return "redirect:/";
            }
        }
        model.addAttribute("loginError","用户名或密码错误");
        return "login";
    }
}
