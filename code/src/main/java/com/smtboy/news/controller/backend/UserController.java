package com.smtboy.news.controller.backend;


import com.smtboy.news.common.Const;
import com.smtboy.news.common.ResponseCode;
import com.smtboy.news.common.ServerResponse;
import com.smtboy.news.request.PutUserMessageVo;
import com.smtboy.news.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author doyledai
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("login")
    public ServerResponse login(String username, String password, HttpSession session){
        ServerResponse response = iUserService.login(username, password);
        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }


    @PostMapping("autoLogin")
    public ServerResponse autoLogin(HttpSession session){
        return iUserService.autoLogin(session);
    }

    @GetMapping("getAllUser")
    public ServerResponse getAllUser(HttpSession session,
                                     @RequestParam(value="pageNum",defaultValue = "1",required = false) int pageNum,
                                     @RequestParam(value="pageSize",defaultValue = "10",required = false) int pageSize){
//        UserLoginVo userLoginVo = (UserLoginVo)session.getAttribute(Const.CURRENT_USER);
//        if (userLoginVo==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
        return iUserService.getAllUser(pageNum, pageSize);
    }

    @GetMapping("getOneUser/{userId}")
    public ServerResponse getOneUser(HttpSession session,@PathVariable int userId){
//        UserLoginVo userLoginVo = (UserLoginVo)session.getAttribute(Const.CURRENT_USER);
//        if (userLoginVo==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
        return iUserService.getOneUser(userId);
    }

    @PutMapping("putOneUser")
    public ServerResponse putOneUser(HttpSession session, PutUserMessageVo putUserMessageVo){
//        UserLoginVo userLoginVo = (UserLoginVo)session.getAttribute(Const.CURRENT_USER);
//        if (userLoginVo==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
        return iUserService.putOneUser(putUserMessageVo);
    }

    @DeleteMapping("deleteOneUser/{userId}")
    public ServerResponse deleteOneUser(HttpSession session,@PathVariable int userId){
//        UserLoginVo userLoginVo = (UserLoginVo)session.getAttribute(Const.CURRENT_USER);
//        if (userLoginVo==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
        return iUserService.deleteOneUser(userId);
    }

    @PostMapping("postOneUser")
    public ServerResponse postOneUser(HttpSession session,String username,String type ,String phone,String email,String password){
//        UserLoginVo userLoginVo = (UserLoginVo)session.getAttribute(Const.CURRENT_USER);
//        if (userLoginVo==null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
        return iUserService.postOneUser(username, type, phone, email, password);
    }

    @GetMapping("checkLogin")
    public ServerResponse checkLogin(){
        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录！");
    }


}
