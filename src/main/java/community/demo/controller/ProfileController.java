package community.demo.controller;

import community.demo.Service.NotificationService;
import community.demo.Service.QuestionService;
import community.demo.dto.NotificationDTO;
import community.demo.mapper.UserMapper;
import community.demo.model.Notification;
import community.demo.model.Question;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/profile/{action}")
    public  String profile(@PathVariable(name = "action")String action, Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        int repliescount = notificationService.countreplies(user.getAccountId());
        int titlecount = questionService.foundquestion(user.getAccountId()).size();
        if (user!=null)request.getSession().setAttribute("unread",repliescount);
        model.addAttribute("repliescount",repliescount);
        model.addAttribute("titlecount",titlecount);

        if ("question".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if ("replies".equals(action)){
            List<Notification> no = notificationService.findthenotification(user.getAccountId());
            System.out.print(no);
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
            model.addAttribute("replieslist",no);

        }


        if (user==null)return "redirect:/";
        else {
            List<Question> questionList = questionService.foundquestion(user.getAccountId());
            model.addAttribute("questions",questionList);
        }
        return "profile";
    }

}
