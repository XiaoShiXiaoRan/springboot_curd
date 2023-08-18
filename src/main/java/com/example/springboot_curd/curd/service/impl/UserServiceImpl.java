package com.example.springboot_curd.curd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_curd.curd.entity.User;
import com.example.springboot_curd.curd.service.UserService;
import com.example.springboot_curd.curd.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xjx
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-08-18 10:11:41
*/

//业务层接口实现类
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public List<User> getList() {

        List<User> userList = baseMapper.getList();

        //业务处理 把所有数据 sex 字段改成男
        userList.forEach(user -> {
            user.setSex("男");
        });

        return userList;
    }
}




