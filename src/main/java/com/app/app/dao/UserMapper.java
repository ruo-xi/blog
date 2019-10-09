package com.app.app.dao;


import com.app.app.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,password) VALUE(#{name},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(User user);


//    @Select("SELECT EXISTS(SELECT * FROM user WHERE username = #(userName) AS ")
//    ResultBean isNameRepeat(@Param("userName") String userName);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(@Param("id") int id);

    @Select("SELECT * FROM user")
    Collection<User> getUsers();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User getUserByName(@Param("name") String name);



    @Update("UPDATE user SET #{param} = #{value} WHERE id = #{id}")
    int updateUserMsg(String param, String value, int id);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    int updateUserP(int id, String password);
}
