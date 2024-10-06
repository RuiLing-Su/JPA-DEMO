package com.rl.jpademo.service.impl;

import com.rl.jpademo.dao.UserDao;
import com.rl.jpademo.entity.UserInfo;
import com.rl.jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 根据用户ID，查询用户信息
     */
    @Override
    public UserInfo findById(int userId)
    {
        return userDao.findById(userId).get();
    }

    /**
     * 查询用户列表
     */
    @Override
    public List<UserInfo> findAll()
    {
        return userDao.findAll();
    }

    /**
     * 新增用户
     */
    @Override
    public UserInfo save(UserInfo userInfo)
    {
        return userDao.save(userInfo);
    }

    /**
     * 修改用户
     */
    @Override
    public UserInfo edit(UserInfo userInfo)
    {
        return userDao.save(userInfo);
    }

    /**
     * 删除用户
     */
    @Override
    public boolean deleteById(int userId)
    {
        boolean result = true;
        try
        {
            userDao.deleteById(userId);
        }
        catch(Exception ex)
        {
            result = false;
        }
        return result;
    }

}
