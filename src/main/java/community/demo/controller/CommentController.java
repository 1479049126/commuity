package community.demo.controller;

import community.demo.Service.CommentService;
import community.demo.Service.NotificationService;
import community.demo.Service.QuestionService;
import community.demo.dto.CommentCreatDTO;
import community.demo.dto.CommentDto;
import community.demo.model.Comment;
import community.demo.model.Notification;
import community.demo.model.Question;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDto commentdto, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return (String)"/comment";
        }

        Comment comment = new Comment();
        Notification notification = new Notification();
        comment.setParentid(commentdto.getParentId());
        comment.setDescription(commentdto.getDescription());
        comment.setType(commentdto.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getAccountId());
        comment.setLikeCount(0);

        //回复以后，把提醒也要插入进去
        Question question =  questionService.foundquestionbyparentid(commentdto.getParentId());
        notification.setDescription(question.getTitle());
        notification.setGmtcreat(comment.getGmtCreate());
        notification.setStatus(0);
        notification.setQuestionparentid(question.getId());
        notification.setNotifier(comment.getCommentator());
        notification.setReceiver(questionService.foundcreator(comment.getParentid()));//提问的人
        //评论的问题
        notification.setType(0);
        //目前还不知道outerId的作用。。。
        notification.setOuterId("0");
        notificationService.insert(notification);
        commentService.insert(comment);
        return "/comment";
    }

}
