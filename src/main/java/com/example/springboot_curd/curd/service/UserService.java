package com.example.springboot_curd.curd.service;

import com.example.springboot_curd.curd.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xjx
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-08-18 10:11:41
*/


//业务层接口
public interface UserService extends IService<User> {

    List<User> getList();

}
