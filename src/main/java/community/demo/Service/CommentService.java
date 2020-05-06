package community.demo.Service;

import community.demo.dto.CommentCreatDTO;
import community.demo.dto.CommentDto;
import community.demo.dto.QuestionDTO;
import community.demo.mapper.CommentMapper;
import community.demo.mapper.QuestionMapper;
import community.demo.mapper.UserMapper;
import community.demo.model.Comment;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public void insert(Comment comment) {

        //找到question
        QuestionDTO question = questionMapper.getByid(comment.getParentid());
        int i = question.getCommunt_Count();
        i++;
        question.setCommunt_Count(i);
        questionMapper.addquestioncomment_count(question.getCommunt_Count(),question.getId());
        commentMapper.insert(comment);
    }

    public List<CommentDto> listByQuestionId(Integer id) {
        List<CommentDto> commentDtos = commentMapper.selectquestion(id);
        for (CommentDto comment:commentDtos){
            User user = userMapper.findById(comment.getCommentator());
            comment.setUser(user);
        }
        return commentDtos;
    }
}
