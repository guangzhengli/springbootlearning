package com.ligz.controller;

import com.ligz.model.User;
import com.ligz.service.RoleService;
import com.ligz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * author:ligz
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @RequestMapping("listUser")
    public ModelAndView listUser() {
        return new ModelAndView("user.jsp").addObject("users", userService.getAllUser());
    }

    @RequestMapping("grantRoleView")
    public ModelAndView grantRoleView(int id) {
        ModelAndView modelAndView = new ModelAndView("grant-role.jsp");
        modelAndView.addObject("user", userService.get(id));
        modelAndView.addObject("roles", roleService.getAll());
        modelAndView.addObject("grantRole", userService.getUserRoles(id));
        return modelAndView;
    }

    @RequestMapping("grantRole")
    @ResponseBody
    public String grantRole(int id, int[] roleId) {
        userService.updateRoles(id, roleId);
        return "success";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUserSubmit(User user) {
        return userService.add(user) > 0 ? "success" : "error";
    }

}
