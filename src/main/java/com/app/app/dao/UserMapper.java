package com.app.app.dao;


import com.app.app.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,password) VALUE(#{name},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(User user);


//    @Select("SELECT EXISTS(SELECT * FROM user WHERE username = #(userName) AS ")
//    ResultBean isNameRepeat(@Param("userName") String userName);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User getUserByName(@Param("name") String name);

    @Update("UPDATE user SET name = #{name} ,address = #{address} ,sex = #{sex} ,intro = #{intro} WHERE id = #{id}")
    int updateBasicMsg(User user);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    int updateUserP(int id, String password);
}
