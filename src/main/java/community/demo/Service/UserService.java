package community.demo.Service;

import community.demo.mapper.UserMapper;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public  void findDBuser(User user) {
        User DBuser = userMapper.findById(user.getAccountId());
        if (DBuser!=null){
            userMapper.update(user);
            //如果DBuser不为空，更新token
        }
        else{
            userMapper.insert(user);
            //如果DBuser为空，将User插入到数据库
        }
    }

    public void updataToken(String token) {
    }


}
