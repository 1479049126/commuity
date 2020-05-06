package community.demo.controller;

import community.demo.Service.RegisterService;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }
    @PostMapping(value = "/register")
    public String login(@RequestParam(name = "reemail") String email,
                        @RequestParam(name ="repassword") String password,
                        @RequestParam(name ="rename") String name,
                        HttpServletRequest request
                        ){
        User user = new User();
        user.setAccountId(email);
        user.setName(name);
        user.setPassword(password);
        if (email!=null&&password!=null&&name!=null){
            registerService.InsertUser(user);
            //token的设置？
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }

        return "register";
    }
}
