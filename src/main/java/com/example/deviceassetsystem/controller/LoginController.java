package com.example.deviceassetsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.deviceassetsystem.entity.User;
import com.example.deviceassetsystem.mapper.UserMapper;
import com.example.deviceassetsystem.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", user.getUsername()).eq("password", user.getPassword());
        User dbUser = userMapper.selectOne(query);

        if (dbUser != null) {
            String token = JwtUtils.generateToken(dbUser.getUsername());
            result.put("code", 200);
            result.put("token", token);
            result.put("msg", "登录成功");
        } else {
            result.put("code", 401);
            result.put("msg", "账号或密码错误");
        }
        return result;
    }
}
