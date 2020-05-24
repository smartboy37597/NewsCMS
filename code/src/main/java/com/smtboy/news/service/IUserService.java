package com.smtboy.news.service;


import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.request.PutUserMessageVo;

import javax.servlet.http.HttpSession;

/**
 * @author doyledai
 */
public interface IUserService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return user
     */
    public ServerResponse login(String username , String password);

    /**
     * 根据session判断是否登陆
     * @param session
     * @return
     */
    public ServerResponse autoLogin(HttpSession session);

    /**
     * 查询所有用户列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getAllUser(int pageNum,int pageSize);

    /**
     * 获取单个用户的信息
     * @param userId
     * @return
     */
    public ServerResponse getOneUser(int userId);

    /**
     * 修改一个user的信息
     * @param putUserMessageVo
     * @return
     */
    public ServerResponse putOneUser(PutUserMessageVo putUserMessageVo);

    /**
     * 删除一个用户
     * @param userId
     * @return
     */
    public ServerResponse deleteOneUser(int userId);

    /**
     * 创建用户
     * @param username
     * @param type
     * @param phone
     * @param email
     * @param password
     * @return
     */
    public ServerResponse postOneUser(String username,String type ,String phone,String email,String password);

}
