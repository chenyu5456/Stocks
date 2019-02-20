package com.stocks.sysservice.model;

import lombok.Data;

/**
 * @Author: ChenYu
 * @Date: 2019/2/20 12:18
 * @Description:
 */
@Data
public class LimitOffset {
    private Integer limit;
    private Integer offset;

    /**
     * 构建分页参数对象
     * @param limit
     * @param offset
     * @return
     */
    public static LimitOffset build(Integer limit, Integer offset){
        LimitOffset limitOffset = new LimitOffset();
        limitOffset.setLimit(limit);
        limitOffset.setOffset(offset);
        return limitOffset;
    }
}
