package com.atme.webssm.service.impl;

import com.atme.webssm.mappers.UserDAO;
import com.atme.webssm.pojo.User;
import com.atme.webssm.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(@Param("uname") String uname,@Param("pwd") String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }
}
