package com.atme.webssm.service;

import com.atme.webssm.pojo.User;

public interface UserService {
    User login(String uname , String pwd);

    void addUser(User user);

    User getUserById(Integer id);
}
