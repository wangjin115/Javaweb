package com.example.demo.demos.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wj
 * @version 1.0
 */
@RestController
@RequestMapping("/uapi/user")
public class LoginController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String userName, @RequestParam String password) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> extra = new HashMap<>();

        // 简单的验证逻辑，实际场景中应查询数据库
        if ("user".equals(userName) && "123".equals(password)) {
            response.put("code", 0);
            response.put("data", "BF21AD52F70FCFBF6F6ADCC6D82A3B6F");

            extra.put("imoocId", "6668507");
            extra.put("avatar", "https://o.devio.org/images/o_as/avatar/txl1.jpeg");
            extra.put("userName", "user");

            response.put("extra", extra);
            response.put("msg", "login success.");
        } else {
            response.put("code", 401);
            response.put("msg", "用户名或密码错误");
        }

        return response;
    }
}
