package com.ligz.mapper;

import com.ligz.model.Role;
import com.ligz.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author:ligz
 */
public interface UserMapper {
    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    List<User> selectALL();

    /**
     * 查询用户拥有的角色列表
     * @param id 用户 id
     * @return 角色列表
     */
    List<Role> selectRolesByPrimaryKey(Integer id);

    /**
     * 删除用户所有角色
     * @param id 用户id
     * @return 删除成功的条数
     */
    int deleteRoles(Integer id);

    /**
     * 为用户赋予角色
     * @param userId userId 用户 id
     * @param id roleId 授予的角色 id
     * @return 插入成功的条数
     */
    int insertUserRole(@Param("user_id") Integer userId, @Param("role_id") Integer id);

    /**
     * 根据用户名密码查询账号是否存在
     * @param username 用户名
     * @param password 密码
     * @return 查询到的账号
     */
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
