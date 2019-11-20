package nuc.bean.homework_login.service;

import nuc.bean.homework_login.dao.UserDao;
import nuc.bean.homework_login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getList(){
        List<User> list = userDao.list();
        return list;
    }

}