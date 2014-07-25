package com.wfc.app.service;

import com.wfc.app.base.BaseService;
import com.wfc.app.dao.UserMapper;
import com.wfc.app.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/7/3.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserService extends BaseService<User> implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> paging(@Param("map") Map<String, Object> map, @Param("startPos") int startPos, @Param("pageSize") int pageSize) {
        return userMapper.paging(map,startPos,pageSize);
    }

    @Override
    public User findUserById(@Param("id") int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByUserName(@Param("userName") String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public int addUser(@Param("user") User user) {
        User user1 = findUserByUserName(user.getUserName());
        if(user1!=null&&user1.getUserName()!=null){//用户已经存在
            return -1;
        }
        return userMapper.addUser(user);
    }
}
