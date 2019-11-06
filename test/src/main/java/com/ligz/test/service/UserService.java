package com.ligz.test.service;

import com.ligz.test.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userService")
public class UserService {
    public User findByName(String userName) {
        User user = new User();
        user.setUsername("用户名为" + userName);
        user.setPassword("ac3af72d9f95161a502fd326865c2f15");
        user.setStatus("1");
        return user;
    }
}
