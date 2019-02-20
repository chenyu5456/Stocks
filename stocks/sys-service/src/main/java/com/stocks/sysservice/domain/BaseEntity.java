package com.stocks.sysservice.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ChenYu
 * @Date: 2019/2/19 11:23
 * @Description: 公共实体类
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 创建人名称
     */
    private String createName;
    private Date createTime;
    private String updateName;
    private Date updateTime;
}
