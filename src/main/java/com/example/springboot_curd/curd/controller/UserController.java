package com.example.springboot_curd.curd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_curd.annotation.LogRecord;
import com.example.springboot_curd.common.ResponseMessage;
import com.example.springboot_curd.curd.entity.User;
import com.example.springboot_curd.curd.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//控制器
//@Controller 不适合返回 json 内容 需要 反序列化     下面自个注解 使用了 @ResponseBody 序列化
// 或者用@Controller 然后在每一个方法上加上 @ResponseBody
@RestController
@RequestMapping("/curd")
public class UserController {

//    引用UserService 调用里面的方法
    @Autowired
    private UserService userService;

    /**
     * 使用mybatis 内置方法条件 分页查询单表数据
     * @param map
     * @return
     */
    @GetMapping("/getPage")
    @ApiOperation(value="分页查询")
    @LogRecord(modular = "分页查询",value = "查询")
//    @ResponseBody
    public ResponseMessage getPage(@RequestParam Map<String,Object> map){ //用map接收传参对象方便

        //获取分页参数
        Integer currentPage = Integer.valueOf(map.get("currentPage").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        //处理分页参数

        //创建 分页对象 指定对象实例 User
        Page<User> page = new Page<>(currentPage, pageSize);

        //创建 条件对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //eq 等于               sex  等于 传过来的 sex
        queryWrapper.eq("sex",map.get("sex"));

        //调用userService 里面的方法 由于 userService 继承了 mybatis-puls 的 IService<User> 所以又很多常用内置方法
        IPage<User> userIPage = userService.page(page,queryWrapper);

        return ResponseMessage.success(userIPage);
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody   //序列化
    public ResponseMessage saveUser(User user){
        /**
         * 新增和修改可同一个方法
         * 因为mybatis-plus 自动处理索引id
         * 传参的时候加上索引id 就自动修改 该条数据
         * 没有传id 参数 就自动为新增操作
         *
         * 新增和修改返回值为布尔值所以用一个布尔值来接收是否新增/修改成功
         */

        boolean ok = userService.saveOrUpdate(user);

        //声明一个对象，不给值 默认为 null;
        Object data;
        if (ok){
            data = "新增/修改成功";
        }else {
            data = "新增/修改失败";
        }

        return ResponseMessage.success(data);
    }


    @RequestMapping(value = "/deleteByUserId", method = RequestMethod.DELETE)
    public ResponseMessage deleteByUserId(String id){

        //根据ID删除

        boolean ok = userService.removeById(id);

        //声明一个对象，不给值 默认为 null;
        Object data;
        if (ok){
            data = "删除成功";
        }else {
            data = "删除失败";
        }

        return ResponseMessage.success(data);
    }


    /**
     * 自定义方法 增删查改 同理
     */
    @GetMapping("/getList")
    public ResponseMessage getList(){

        List<User> list = userService.getList();

        return ResponseMessage.success(list);
    }

}
