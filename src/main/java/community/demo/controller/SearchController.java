package community.demo.controller;

import community.demo.Service.QuestionService;
import community.demo.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@Controller
//
//public class SearchController {
//    public QuestionService questionService;
//    @GetMapping("/")
//    public String Search(@RequestParam(name = "search")String search, Model model){
//        List<Question>questions = questionService.search(search);
//        if (questions.size()!=0){
//            model.addAttribute("questions",questions);
//            return "search";
//        }
//        return "/";
//    }
//}
