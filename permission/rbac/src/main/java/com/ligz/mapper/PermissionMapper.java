package com.ligz.mapper;

import com.ligz.model.Permission;

import java.util.List;

/**
 * author:ligz
 */
public interface PermissionMapper {
    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectAll();
}
