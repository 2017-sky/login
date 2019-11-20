package nuc.bean.homework_login.dao;

import nuc.bean.homework_login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    public List<User> list();
}
