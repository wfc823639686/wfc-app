package com.wfc.app.dao;

import com.wfc.app.base.Paging;
import com.wfc.app.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/7/3.
 */
public interface UserMapper  extends Paging<User> {

    /**
     * findUserById
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("user")
    User findUserById(@Param("id") int id);

    /**
     * findUserByUserName
     * @param userName
     * @return
     */
    @Select("select * from user where user_name=#{userName}")
    @ResultMap("user")
    User findUserByUserName(@Param("userName")String userName);


    /**
     * addUser
     * @param user
     * @return
     */
    @Insert("insert into user(user_name,password,phone,address)"+
            " values(#{user.userName},#{user.password},#{user.phone},#{user.address})")
    int addUser(@Param("user") User user);

    /**
     * paging
     * @param map
     * @param startPos
     * @param pageSize
     * @return
     */
    @Select("select * from user limit #{startPos},#{pageSize}")
    @ResultMap(value = "user")
    @Override
    List<User> paging(@Param("map")Map<String,Object> map,@Param("startPos")int startPos,@Param("pageSize") int pageSize);
}
