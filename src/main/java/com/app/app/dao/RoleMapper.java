package com.app.app.dao;

import com.app.app.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper {

    @Select("")
    Role getRoleById(Role role);

    @Insert("INSERT INTO role(id, role) VALUE(#{id}, #{name})")
    Role setRoleById(Role role);
}
