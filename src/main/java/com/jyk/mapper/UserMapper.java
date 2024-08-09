package com.jyk.mapper;

import com.jyk.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : User类操作数据库接口
 * @date : Created in 2024/7/27 19:58
 */
@Mapper // 表示这是一个 Mybatis 的 mapper 类
// @Repository
public interface UserMapper {
    List<User> selectAllUser();

    User selectUserByAccount(@Param("account") String account);

    User getUserById(Integer id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);
}
