package community.demo.mapper;

import community.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select count(1) from user where ACCOUNTID=#{accountId} and PASSWORD = #{password}")
    int findUser(User user);
    @Select("select NAME from user where ACCOUNTID=#{accountId}")
    String findName(User user);
}
