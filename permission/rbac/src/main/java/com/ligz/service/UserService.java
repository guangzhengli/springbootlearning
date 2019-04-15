package com.ligz.service;

import com.ligz.mapper.UserMapper;
import com.ligz.model.Role;
import com.ligz.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author:ligz
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int add(User user) {
        return userMapper.insert(user);
    }

    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getAllUser() {
        return userMapper.selectALL();
    }

    public List<Role> getUserRoles(Integer id) {
        return userMapper.selectRolesByPrimaryKey(id);
    }

    public void updateRoles(Integer id, int[] roleIds) {
        userMapper.deleteRoles(id);
        if (roleIds != null) {
            for (int roleId : roleIds) {
                userMapper.insertUserRole(id, roleId);
            }
        }
    }

    public User selectUserByUsernameAndPassword(String username, String password) {
        return userMapper.selectUserByUsernameAndPassword(username, password);
    }

}
