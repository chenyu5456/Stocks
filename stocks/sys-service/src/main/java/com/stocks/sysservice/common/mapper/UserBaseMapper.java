package com.stocks.sysservice.common.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: ChenYu
 * @Date: 2019/2/18 14:09
 * @Description: 所有mapper类的父类
 */
public interface UserBaseMapper<T> extends BaseMapper<T>,MySqlMapper<T> {
}
