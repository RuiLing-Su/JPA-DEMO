package com.rl.jpademo.controller;

import com.rl.jpademo.entity.UserInfo;
import com.rl.jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 查询所有用户
    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userService.findAll();
    }

    // 根据ID查询用户
    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    // 添加新用户
    @PostMapping
    public UserInfo addUser(@RequestBody UserInfo user) {
        return userService.save(user);
    }

    // 修改用户
    @PutMapping("/{id}")
    public UserInfo updateUser(@PathVariable int id, @RequestBody UserInfo user) {
        user.setUserId(id);
        userService.edit(user);
        return user;
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if (userService.deleteById(id)) {
            return "删除用户成功";
        } else {
            return "删除用户失败";
        }
    }
}
