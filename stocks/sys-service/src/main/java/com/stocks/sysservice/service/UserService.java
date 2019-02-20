package com.stocks.sysservice.service;

import com.stocks.sysservice.domain.User;
import com.stocks.sysservice.mapper.UserMapper;
import com.stocks.sysservice.utils.BeanHelper;
import com.stocks.sysservice.utils.HashUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ChenYu
 * @Date: 2019/2/20 14:00
 * @Description:
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public boolean addAccount(User user){
        //使用md5对密码加密
        user.setPassword(HashUtils.encryPassword(user.getPassword()));
        BeanHelper.onInsert(user);
        int insert = userMapper.insert(user);

        return insert==1 ? true : false;
    }

}
