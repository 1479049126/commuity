package community.demo.controller;

import community.demo.Service.CommentService;
import community.demo.Service.QuestionService;
import community.demo.dto.CommentCreatDTO;
import community.demo.dto.CommentDto;
import community.demo.dto.QuestionDTO;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("question/{id}")
    public String question(@PathVariable(name = "id") Integer id, Model model){
        QuestionDTO questionDTO = questionService.question(id);
        String[] tags = questionDTO.getTags().split(",");
        List<QuestionDTO> questionDTOList = null;
        for (String tag:tags) {
            questionDTOList= questionService.findquestionbytags(tag);
            if (questionDTOList.size()>=2)break;
        }
        model.addAttribute("questionTaglist",questionDTOList);
        model.addAttribute("question",questionDTO);
        model.addAttribute("tags",tags);
        List<CommentDto> comments = commentService.listByQuestionId(id);
        model.addAttribute("comments",comments);
        return "question";
    }
}
