package org.example.hdfs.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.hdfs.common.pojo.entity.User;

/**
 * ClassName: UserMapper
 * Package: org.example.hdfs.mapper
 * Description:
 *
 * @Author: Alexios
 * @Create: 2024/10/17 - 17:57
 * @Version: v1.0
 */
@Mapper
public interface UserMapper {

     //使用用户名查询用户
    @Select("select * from user where user_name= #{userName}")
    User getByUserName(String userName);

    //向数据库插入注册用户信息
    @Insert("insert into user (user_name,pwd,user_path)" +
            "values "+
            "(#{userName},#{pwd},#{userPath})")
    void insert(User user);
}
