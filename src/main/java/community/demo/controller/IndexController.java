package community.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import community.demo.Service.NotificationService;
import community.demo.Service.QuestionService;
import community.demo.dto.QuestionDTO;
import community.demo.mapper.UserMapper;
import community.demo.model.Question;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model, @RequestParam(name = "pageNum",defaultValue = "1")Integer page,@RequestParam(name = "pageSize",defaultValue = "5")Integer size,@RequestParam(name = "search",required = false)String search){
        User user = (User) request.getSession().getAttribute("user");
        //List<QuestionDTO> questionList = questionService.list(page,size);
        PageHelper.startPage(page,size);
        //List<QuestionDTO>questionDTOList = questionService.list();
        List<Question>question = questionService.abc();
        //PageInfo pageInfo = new PageInfo(questionDTOList);
        PageInfo pageInfo = new PageInfo(question);
        //System.out.println(question.size());
        List<QuestionDTO>questionDTOList = questionService.list(question);
        System.out.println(pageInfo);
        if (search!=null){
            List<Question>questions = questionService.search(search);
            if (questions.size()!=0){
                model.addAttribute("questions",questions);
                return "search";
            }
        }
        model.addAttribute("questions",questionDTOList);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
//    @RequestMapping("/")
//    public String Search(@RequestParam(name = "search")String search, Model model){
//        List<Question>questions = questionService.search(search);
//        if (questions.size()!=0){
//            model.addAttribute("questions",questions);
//            return "search";
//        }
//        return "/";
//    }

}
