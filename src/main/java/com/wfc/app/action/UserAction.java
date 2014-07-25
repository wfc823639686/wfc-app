package com.wfc.app.action;

import com.wfc.app.base.BaseAction;
import com.wfc.app.base.JSONResultAction;
import com.wfc.app.po.User;
import com.wfc.app.service.UserService;
import com.wfc.app.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2014/7/3.
 */
@Controller
public class UserAction extends JSONResultAction {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private User user;

    private Integer id;

    private String userName;

    private String password;

    private Integer p;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public String login(){
        User user = userService.findUserByUserName(userName);
        session.put(Constants.USER_INFO,user);
        jsonResult.put(JR_DATA,user);
        return JSON_RESULT;
    }

    public void validateAddUser(){
        jsonResult.put(JR_DATA,"yz");
        super.validate() ;
    }

    public String addUser(){
        int result = userService.addUser(user);
        if(result==0){
            jsonResult.put(JR_STATE,0);
            jsonResult.put(JR_MESSAGE,"注册失败");
        }else if (result==-1){
            jsonResult.put(JR_STATE,-1);
            jsonResult.put(JR_MESSAGE,"用户已存在");
        }else{
            jsonResult.put(JR_STATE,1);
            jsonResult.put(JR_MESSAGE,"注册成功");
        }
        return JSON_RESULT;
    }

    public String userList(){
        List<User> userList = userService.pagingByPage(map,p,10);
        jsonResult.put(JR_DATA,userList);
        return JSON_RESULT;
    }

    public String userInfo(){
        User user = userService.findUserById(id);
        if(user!=null&&user.getId()!=null){
            jsonResult.put(JR_STATE,1);
        }else{
            jsonResult.put(JR_STATE,0);
        }
        jsonResult.put(JR_DATA,user);
        return JSON_RESULT;
    }

}
