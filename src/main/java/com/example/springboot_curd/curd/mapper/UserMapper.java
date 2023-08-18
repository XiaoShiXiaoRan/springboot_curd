package com.example.springboot_curd.curd.mapper;

import com.example.springboot_curd.curd.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author xjx
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-08-18 10:11:41
* @Entity com.example.springboot_curd.curd.entity.User
*/

//持久层接口
public interface UserMapper extends BaseMapper<User> {

    List<User> getList();
}




