package community.demo.controller;

import community.demo.Service.QuestionService;
import community.demo.dto.GithubUser;
import community.demo.dto.QuestionDTO;
import community.demo.mapper.QuestionMapper;
import community.demo.mapper.UserMapper;
import community.demo.model.Question;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller

public class PublishController {
@Autowired
private QuestionMapper questionMapper;
@Autowired
private QuestionService questionService;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @RequestMapping("/publish")
    public String dopublish(@RequestParam(name = "title") String title,
                            @RequestParam(name ="description") String description,
                            @RequestParam(name = "tag")String tag,
                            @RequestParam(name = "id")Integer id,
                            HttpServletRequest request,
                            Model model
    ){


        //判断是否填入信息
        if (title==null) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description==null) {
            model.addAttribute("error", "描述信息不能为空");
            return "publish";
        }
        if (tag==null) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
         User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            model.addAttribute("error","用户未登录");
            return "publish";//这里逻辑有问题，在没有登录情况下应无法发表
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescriptions(description);
        question.setTags(tag);
        question.setCreat_Name(user.getAccountId());
        question.setGmt_Create(System.currentTimeMillis());
        question.setGmt_Modified(question.getGmt_Create());
        question.setId(id);
        questionService.creatOrupdata(question);
        return "redirect:/";

    }
    @GetMapping("/publish/{id}")
    private String edit(@PathVariable(name = "id") Integer id,Model model){
        QuestionDTO question = questionMapper.getByid(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescriptions());
        model.addAttribute("tag",question.getTags());
        return "publish";
    }
}
