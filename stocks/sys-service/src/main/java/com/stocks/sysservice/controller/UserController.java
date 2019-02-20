package com.stocks.sysservice.controller;

import com.stocks.sysservice.common.ApiResponse;
import com.stocks.sysservice.domain.User;
import com.stocks.sysservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ChenYu
 * @Date: 2019/2/20 14:08
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/account/addUser")
    public ApiResponse addAccount(@RequestBody User user){
        boolean result = userService.addAccount(user);
        if(result){
            return ApiResponse.ofMessage(200, "注册成功");
        }else {
            return ApiResponse.ofMessage(501, " 注册失败");
        }
    }
}
