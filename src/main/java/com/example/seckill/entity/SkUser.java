package com.example.seckill.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SkUser)实体类
 *
 * @author makejava
 * @since 2020-06-24 09:29:23
 */
public class SkUser implements Serializable {
    private static final long serialVersionUID = 618756447551239052L;
    /**
    * 用户id
    */
    private Object id;
    /**
    * 昵称
    */
    private String nickname;
    /**
    * MD5(MD5(pass明文+固定salt)+salt
    */
    private String password;
    /**
    * 混淆盐
    */
    private String salt;
    /**
    * 头像，云存储的ID
    */
    private String head;
    /**
    * 注册时间
    */
    private Date registerDate;
    /**
    * 上次登录时间
    */
    private Date lastLoginDate;
    /**
    * 登录次数
    */
    private Integer loginCount;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

}