/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pack.UserProfile;

/**
 *
 * @author sl
 */
public interface UserDao {
    //用户登陆方法声明/回调声明 查询的方法都是返回的对象 返回查询的对象 或者是list对象或者是VO类对象
    public UserProfile login(UserProfile user);
    //用户注册方法声明/回调声明 //增加更新删除的方法 插入的方法都是返回一个布尔值 成功或者失败
    public boolean register(UserProfile user);
    //查询用户的信息
    public List<UserProfile>selectUser(String sql,Object[]arr);
}
