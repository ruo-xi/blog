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
    Integer add(User user);


//    @Select("SELECT EXISTS(SELECT * FROM user WHERE username = #(userName) AS ")
//    ResultBean isNameRepeat(@Param("userName") String userName);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(@Param("id") Integer id);

    @Select("SELECT * FROM user")
    Collection<User> getUsers();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User getUserByName(@Param("name") String name);

    @Select("SELECT id FROM user WHERE name = #{name} AND password = #{password}")
    Integer getIdByNP(@Param("name") String name, @Param("password") String password);

    @Update("UPDATE user SET #{param} = #{value} WHERE id = #{id}")
    Integer updateUserMsg(String param, String value, Integer id);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    Integer updateUserP(Integer id, String password);
}
