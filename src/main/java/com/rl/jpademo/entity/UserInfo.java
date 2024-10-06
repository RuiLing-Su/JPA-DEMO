package com.rl.jpademo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
public class UserInfo {
    //用户ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    //用户姓名
    @Column(name = "user_name")
    private String userName;

    //博客地址
    @Column(name = "blog_url")
    private String blogUrl;

    //备注
    private String remark;

}