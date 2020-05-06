package community.demo.Service;

import community.demo.dto.QuestionDTO;
import community.demo.mapper.QuestionMapper;
import community.demo.mapper.UserMapper;
import community.demo.model.Question;
import community.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list(List<Question> questions) {
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreat_Name());//获得的是每个问题对应的user
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);//把所有question的属性拷贝到questionDTO
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        //System.out.println(questions.size());

        return questionDTOList;

    }
    public List<Question> abc(){
        List<Question> questions= questionMapper.list();

        return questions;
    }

    public List<Question> foundquestion(String AccountId) {//找到AccoutID所对应的所有问题
        List<Question> questions = questionMapper.foundquestion(AccountId);
        return questions;
    }

    public QuestionDTO question(Integer id) {
        QuestionDTO questionDTO = questionMapper.getByid(id);
        User user = userMapper.findById(questionDTO.getCreat_Name());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void creatOrupdata(Question question) {
        if (question.getId()==null){
            questionMapper.create(question);
        }
        else {
            questionMapper.updata(question);
        }
    }

    public List<QuestionDTO> findquestionbytags(String tag) {
        return questionMapper.findquestionbytags(tag);
    }
    public String foundcreator(long parentId){
        return questionMapper.findcreator(parentId);
    }
    public Question foundquestionbyparentid(int parentid){
        return questionMapper.findquestionbyparentid(parentid);
    }

    public List<Question> search(String search) {
        return questionMapper.search(search);
    }
}
