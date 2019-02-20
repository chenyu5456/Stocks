package com.stocks.sysservice.mapper;

import com.stocks.sysservice.common.mapper.UserBaseMapper;
import com.stocks.sysservice.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ChenYu
 * @Date: 2019/2/18 11:07
 * @Description:
 */
@Mapper
public interface UserMapper extends UserBaseMapper<User> {
}
