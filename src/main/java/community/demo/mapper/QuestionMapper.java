package community.demo.mapper;

import community.demo.dto.QuestionDTO;
import community.demo.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface QuestionMapper {
    @Insert("insert into question (title,Descriptions, Gmt_Create, Gmt_Modified, Creat_Name,Tags) values(#{Title},#{Descriptions},#{Gmt_Create},#{Gmt_Modified},#{Creat_Name},#{Tags})")//这里不能加逗号
    void create(Question question);
    @Select("select * from question")
    List<Question> list();
    @Select("select * from question where Creat_Name = #{creatID}")
    List<Question> foundquestion(@Param("creatID") String creatID);
    @Select("select * from question where id =#{id}")
    QuestionDTO getByid(Integer id);
    @Update("update question set title = #{Title}, Descriptions = #{Descriptions},Gmt_Create = #{Gmt_Create},Gmt_Modified = #{Gmt_Modified},Tags = #{Tags} where id = #{id}")
    void updata(Question question);
    @Update("update question set Communt_Count = #{question_count} where id = #{question_id}")
    void addquestioncomment_count(Integer question_count, Integer question_id);
    @Select("select * from question where Tags like '%${tag}%' limit 5")
    List<QuestionDTO> findquestionbytags(@Param("tag") String tag);
    @Select("select Creat_Name from question where id = #{parentId}")
    String findcreator(long parentId);
    @Select("select * from question where id = #{parentid}")
    Question findquestionbyparentid(@Param("parentid") int parentid);
    @Select("select * from question where descriptions like '${search}%' ")
    List<Question> search(@Param(value="search")String search);
}
