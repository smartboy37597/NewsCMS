package com.smtboy.news.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smtboy.news.common.Const;
import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.dao.UserMapper;
import com.smtboy.news.pojo.News;
import com.smtboy.news.pojo.User;
import com.smtboy.news.request.PostNewsMessageVo;
import com.smtboy.news.request.PutUserMessageVo;
import com.smtboy.news.service.IUserService;
import com.smtboy.news.util.Sha256;
import com.smtboy.news.vo.UserLoginVo;
import com.smtboy.news.vo.UserMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author doyledai
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ServerResponse login(String username , String password) {

        User user = userMapper.selectAdminUserByUsername(username);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户名或密码错误！");
        }
        String oldPwd = user.getPassword();
        if (!oldPwd.equals(Sha256.getSHA256(password))) {
            return ServerResponse.createByErrorMessage("用户名或密码错误！");
        }
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setCreateTime(user.getCreateTime());
        userLoginVo.setId(user.getId());
        userLoginVo.setMail(user.getMail());
        userLoginVo.setMobile(user.getMobile());
        userLoginVo.setName(user.getName());
        userLoginVo.setType(user.getType());
        return ServerResponse.createBySuccess("登陆成功",userLoginVo);
    }

    /**
     * 根据session判断是否登陆
     * @param session
     * @return
     */
    @Override
    public ServerResponse autoLogin(HttpSession session){
        UserLoginVo userLoginVo = (UserLoginVo)session.getAttribute(Const.CURRENT_USER);
        if (userLoginVo==null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return ServerResponse.createBySuccess("登陆成功",userLoginVo);
    }

    /**
     * 查询所有用户列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getAllUser(int pageNum, int pageSize){
        //startpage
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUser();
        PageInfo pageInfo = new PageInfo(users);
        pageInfo.setList(users);
        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 获取单个用户的信息
     * @param userId
     * @return
     */
    @Override
    public ServerResponse getOneUser(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMessage("查询失败！");
        }
        UserMessageVo userMessageVo = new UserMessageVo();
        userMessageVo.setCreateTime(user.getCreateTime());
        userMessageVo.setId(user.getId());
        userMessageVo.setMail(user.getMail());
        userMessageVo.setMobile(user.getMobile());
        userMessageVo.setName(user.getName());
        userMessageVo.setType(user.getType());
        userMessageVo.setUpdateTime(user.getUpdateTime());
        return ServerResponse.createBySuccess(userMessageVo);
    }

    /**
     * 修改一个user的信息
     * @param putUserMessageVo
     * @return
     */
    @Override
    public ServerResponse putOneUser(PutUserMessageVo putUserMessageVo){
        System.out.println(putUserMessageVo);
        User user = new User();
        user.setId(putUserMessageVo.getId());
        if (!putUserMessageVo.getMail().equals("") && putUserMessageVo.getMail() != null) {
            System.out.println(1);
            user.setMail(putUserMessageVo.getMail());
        }
        if (!putUserMessageVo.getMobile().equals("") && putUserMessageVo.getMobile() != null) {
            System.out.println(2);
            user.setMobile(putUserMessageVo.getMobile());
        }
        if (!putUserMessageVo.getName().equals("") && putUserMessageVo.getName() != null) {
            System.out.println(3);
            user.setName(putUserMessageVo.getName());
        }
        if (!putUserMessageVo.getType().equals("") && putUserMessageVo.getType() != null) {
            System.out.println(4);
            user.setType(putUserMessageVo.getType());
        }
        System.out.println("user:"+user);
        int resultCount = userMapper.updateByPrimaryKeySelective(user);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    /**
     * 删除一个用户
     * @param userId
     * @return
     */
    @Override
    public ServerResponse deleteOneUser(int userId){
        int resultCount = userMapper.deleteByPrimaryKey(userId);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    /**
     * 创建用户
     * @param username
     * @param type
     * @param phone
     * @param email
     * @param password
     * @return
     */
    @Override
    public ServerResponse postOneUser(String username,String type ,String phone,String email,String password){
        User user = new User();
        user.setName(username);
        user.setType(type);
        user.setMobile(phone);
        user.setMail(email);
        user.setPassword(Sha256.getSHA256(password));
        int resultCount = userMapper.insert(user);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }


}
