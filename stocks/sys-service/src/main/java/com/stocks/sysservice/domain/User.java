package com.stocks.sysservice.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: ChenYu
 * @Date: 2019/2/18 11:05
 * @Description:
 */
@Data
public class User extends BaseEntity{
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String account;
    private String password;
    private String phone;
    private Date birthday;
    private String sex;
}
