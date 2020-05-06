package community.demo.mapper;

import community.demo.dto.CommentDto;
import community.demo.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("Insert into comment(parentId,Description,Type,GmtCreate,GmtModified,LikeCount,Commentator) values (#{parentid},#{Description},#{Type},#{GmtCreate},#{GmtModified},#{LikeCount},#{Commentator})")
    void insert(Comment comment);
    @Select("Select * from comment c inner join user u on c.Commentator = u.ACCOUNTID where c.parentId = #{id}")
    List<CommentDto> selectquestion(Integer id);
}
