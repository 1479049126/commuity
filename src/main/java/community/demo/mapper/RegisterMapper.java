package community.demo.mapper;

import community.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    @Insert("insert into user (ACCOUNTID,NAME,PASSWORD) values(#{accountId},#{name},#{password})")
    void insertUser(User user);
}
