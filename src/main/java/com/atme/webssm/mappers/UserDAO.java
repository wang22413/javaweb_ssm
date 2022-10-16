package com.atme.webssm.mappers;

import com.atme.webssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserDAO {

    /**
     * 通过用户名和密码返回用户信息
     * @param uname
     * @param pwd
     * @return
     */
    User getUser(@Param("uname") String uname,@Param("pwd") String pwd);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 通过姓名返回用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

}
