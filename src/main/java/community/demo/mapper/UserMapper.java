package community.demo.mapper;

import community.demo.model.User;
import org.apache.ibatis.annotations.*;


@Mapper

public interface UserMapper {

    @Insert("Insert into user (name,accountid,token,gmtcreate,gmtmodified,Avatar_Url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{Avatar_Url})")
    void insert(User user);
    @Select("select * from user where TOKEN = #{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where ACCOUNTID = #{id} limit 1")
    User findById(@Param("id") String creat_name);
    @Update("UPDATE user SET TOKEN = #{token},NAME = #{name} where ACCOUNTID = #{accountId}")
    void update(User user);
}
