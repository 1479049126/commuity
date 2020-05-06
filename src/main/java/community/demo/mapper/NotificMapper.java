package community.demo.mapper;

import community.demo.model.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NotificMapper {
    @Select("select * from notification where status = 0 And receiver= #{receiver}")//这里还没改
    List<Notification> findthenotification(String receiver);
    @Update("update notification set status = 1 where ID = #{id}")
    void updatestatus(int id);
    @Insert("insert into notification (notifier,receiver,outerId,type,gmtcreat,status,description,questionparentid) values (#{notifier},#{receiver},#{outerId},#{type},#{gmtcreat},#{status},#{description},#{questionparentid})")
    void insert(Notification notification);
    @Select("select count(1) from notification where status = 0 and receiver = #{accountId}")
    int countreplies(String accountId);
}
