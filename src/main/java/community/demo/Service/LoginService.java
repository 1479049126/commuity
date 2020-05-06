package community.demo.Service;

import community.demo.mapper.LoginMapper;
import community.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    public boolean findUser(User user) {
        int count = 0;
        if (loginMapper.findUser(user)>0)return true;
        else return false;
    }
    public String findName(User user){
        return loginMapper.findName(user);
    }
}
