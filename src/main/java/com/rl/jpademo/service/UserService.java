package com.rl.jpademo.service;

import com.rl.jpademo.entity.UserInfo;

import java.util.List;

public interface UserService
{
    /**
     * 根据用户ID，查询用户信息
     */
    public UserInfo findById(int userId);

    /**
     * 查询用户列表
     */
    public List<UserInfo> findAll();

    /**
     * 新增用户
     */
    public UserInfo save(UserInfo userInfo);

    /**
     * 修改用户
     */
    public UserInfo edit(UserInfo userInfo);

    /**
     * 删除用户
     */
    public boolean deleteById(int userId);

}
