package com.rl.jpademo;

import com.rl.jpademo.entity.UserInfo;
import com.rl.jpademo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        UserInfo user = userService.findById(1);

        if (user != null){
            System.out.println("用户编号：" + user.getUserId());
            System.out.println("用户姓名：" + user.getUserName());
            System.out.println("博客地址：" + user.getBlogUrl());
            System.out.println("备注信息：" + user.getRemark());
        }
    }
    /**
     * 测试：查询用户列表
     * @author ruiling
     */
    @Test
    public void findAll()
    {
        //查询用户列表
        List<UserInfo> userList = userService.findAll();

        if (userList != null && userList.size() > 0)
        {
            for (UserInfo user : userList)
            {
                //打印结果
                System.out.println("用户编号：" + user.getUserId());
                System.out.println("用户姓名：" + user.getUserName());
                System.out.println("博客地址：" + user.getBlogUrl());
                System.out.println("备注信息：" + user.getRemark());
                System.out.println("===========================================");
            }
        }
    }

    /**
     * 测试：新增用户
     * @author ruiling
     */
    @Test
    public void save()
    {
        //创建新用户
        UserInfo user = new UserInfo();
        user.setUserName("ruiling的博客_03");
        user.setBlogUrl("http://ruiling.online/archives/mybatis-data-jpa");
        user.setRemark("您好，欢迎访问ruiling的博客");

        //执行新增操作
        userService.save(user);

        //如果新增成功，则可以获取自增主键
        //否则新增失败，则抛出异常
        if (user.getUserId() > 0)
        {
            System.out.println("新增用户成功，新增的用户信息：");
            System.out.println("用户编号：" + user.getUserId());
            System.out.println("用户姓名：" + user.getUserName());
            System.out.println("博客地址：" + user.getBlogUrl());
            System.out.println("备注信息：" + user.getRemark());
        }
    }

    /**
     * 测试：修改用户
     * @author ruiling
     */
    @Test
    public void edit()
    {
        //创建修改用户
        UserInfo user = new UserInfo();
        user.setUserId(3);
        user.setUserName("ruiling的博客_04");
        user.setBlogUrl("http://ruiling.online/archives/mybatis-data-jpa");
        user.setRemark("您好，欢迎访问 ruiling的博客");

        //执行修改操作
        userService.edit(user);

        //如果没有抛出异常，则表示执行成功
        System.out.println("修改用户成功");
    }

    /**
     * 测试：删除用户
     * @author ruiling
     */
    @Test
    public void deleteById()
    {
        //执行新增操作
        boolean result = userService.deleteById(3);

        //打印结果
        if (result)
        {
            System.out.println("删除用户成功");
        }
        else
        {
            System.out.println("删除用户失败");
        }
    }

}
