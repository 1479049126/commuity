package community.demo.Service;

import community.demo.mapper.RegisterMapper;
import community.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    RegisterMapper registerMapper;
    public void InsertUser(User user) {
        registerMapper.insertUser(user);
    }
}
