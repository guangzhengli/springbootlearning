package com.ligz.service;

import com.ligz.mapper.PermissionMapper;
import com.ligz.model.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author:ligz
 */
@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    public Integer add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    public List<Permission> getAll() {
        return permissionMapper.selectAll();
    }
}
